package com.explore.member.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.constant.ConstantSys;
import com.explore.common.encryption.CryptoUtil;
import com.explore.common.exception.BaseException;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.common.tool.DateTool;
import com.explore.common.tool.StringTool;
import com.explore.member.persist.BusinessMapper;
import com.explore.member.persist.MemberGroupMapper;
import com.explore.member.persist.MemberMapper;
import com.explore.member.persist.OauthMapper;
import com.explore.member.persist.PersonMapper;
import com.explore.model.member.Business;
import com.explore.model.member.Member;
import com.explore.model.member.MemberGroup;
import com.explore.model.member.Oauth;
import com.explore.model.member.Person;

/**
 * <p>
 * 会员信息表 服务实现类
 * </p>
 *1.插入会员主表信息
 *2.插入认证信息
 *3.个人信息表
 *4.企业信息表
 *5.默认分组信息
 * @author wwangtaoc11@gamil.com
 * @since 2022-11-30
 */
@Service
public class MemberService extends ServiceImpl<MemberMapper, Member>  {
	private final static Logger logger=LoggerFactory.getLogger(MemberService.class);
	@Autowired
	MemberGroupMapper memberGroupMapper;
	@Autowired
	BusinessMapper businessMapper;
	@Autowired
	PersonMapper personMapper;
	@Autowired
	OauthMapper oauthMapper;
	@Autowired
	OauthService oauthService;
	/**
	 * 插入会员信息主表-内部使用
	 * @param jsonObject
	 * @return
	 */
	private int insertMember(JSONObject jsonObject) {
		String uid = jsonObject.getString("uid");
		String category = jsonObject.getString("category");
		String remoteAddr = jsonObject.getString("remoteAddr");
		Member mem = new Member();
		mem.setUid(uid);
		mem.setStatus(Member.MEMBER_STATUS_AVAILABLE);
		mem.setCategory(category);
		mem.setCreateAt(DateTool.currentTime());
		mem.setCreateIp(remoteAddr);
		int insert = this.baseMapper.insert(mem);
		return insert;
	}
	/**
	 * 注册
	 * @param requestMsg
	 * @return
	 */
	public ResponseMessage regsub(RequestMessage requestMsg) {
		ResponseMessage responseMessage = ResponseMessage.success();
		try {
			JSONObject jsonObject = requestMsg.getBody().getContent();
			String uid = jsonObject.getString("uid");
			String category = jsonObject.getString("category");
			String remoteAddr = jsonObject.getString("remoteAddr");
			String credential = jsonObject.getString("credential");
			String username = jsonObject.getString("username");
			//1.插入会员主表信息
			insertMember(jsonObject);
			//2.插入认证表信息
			List<Oauth> oList = new ArrayList<>();
			for (int i = 0; i < 2; i++) {
				Oauth oauth = new Oauth();
				String salt = StringTool.getUuid();
				String passwd = CryptoUtil.simpleHash(CryptoUtil.SIMPLEHASH_SHA512, credential, salt, CryptoUtil.HASHITERATIONS_DEFAULT);
				oauth.setUid(uid);
				oauth.setCredential(passwd);
				oauth.setPasswd(salt);
				if (i==0) {
					oauth.setOauthType(Oauth.OAUTH_OAUTHTYPE_EMAIL);	
				} else {
					oauth.setOauthType(Oauth.OAUTH_OAUTHTYPE_UNAME);	
				}
				
				oauth.setNickname(username);
				oList.add(oauth);
			}			
			this.oauthService.insertOauthBatch(oList);
						
			Person p = new Person();
			this.personMapper.insert(p);
			Business business = new Business();
			this.businessMapper.insert(business );
			//5.插入默认分组信息
			MemberGroup memGroup = new MemberGroup();
			memGroup.setUid(uid);
			if (Member.MEMBER_CATEGORY_BUSINESS.equals(category)) {
				memGroup.setGroupCode(MemberGroup.MEMBER_GROUPCODE_BUSINESS);
			}else {
				memGroup.setGroupCode(MemberGroup.MEMBER_GROUPCODE_PERSON);
			}
			
			this.memberGroupMapper.insert(memGroup);
			
				
		} catch (BaseException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw new BaseException(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new BaseException(ConstantSys.SYS_ERROR);
		}
		return responseMessage;
		
	}
	
	/**
	 * 修改会员信息主表
	 * @param requestMsg
	 * @return
	 */
	public ResponseMessage updateMemberById(RequestMessage requestMsg) {
		ResponseMessage responseMessage = ResponseMessage.success();
		try {
			JSONObject jsonObject = requestMsg.getBody().getContent();
			Member po = jsonObject.toJavaObject(Member.class);
			this.baseMapper.updateById(po);
		} catch (BaseException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw new BaseException(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new BaseException(ConstantSys.SYS_ERROR);
		}
		return responseMessage;
	}
}
