package com.explore.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.constant.ConstantSys;
import com.explore.common.exception.BaseException;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
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
	private final static Logger logger=LoggerFactory.getLogger(OauthService.class);
	@Autowired
	MemberGroupMapper memberGroupMapper;
	@Autowired
	BusinessMapper businessMapper;
	@Autowired
	PersonMapper personMapper;
	@Autowired
	OauthMapper oauthMapper;
	/**
	 * 注册
	 * @param requestMsg
	 * @return
	 */
	public ResponseMessage regsub(RequestMessage requestMsg) {
		ResponseMessage responseMessage = ResponseMessage.success();
		try {
			JSONObject jsonObject = requestMsg.getBody().getContent();
			Member mem = new Member();
			this.baseMapper.insert(mem);
			Oauth oauth = new Oauth();
			this.oauthMapper.insert(oauth);
			Person p = new Person();
			this.personMapper.insert(p);
			Business business = new Business();
			this.businessMapper.insert(business );
			MemberGroup memGroup = new MemberGroup();
			this.memberGroupMapper.insert(memGroup);
			
				
		} catch (BaseException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw new BaseException(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw new BaseException(ConstantSys.SYS_ERROR);
		}
		return responseMessage;
		
	}
}
