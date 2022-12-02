package com.explore.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.constant.ConstantMemRedis;
import com.explore.common.constant.ConstantSys;
import com.explore.common.encryption.CryptoUtil;
import com.explore.common.exception.BaseException;
import com.explore.common.redis.ObjectRedisTemplate;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.common.tool.FastJsonTool;
import com.explore.common.tool.StringTool;
import com.explore.member.persist.MemberOauthViewMapper;
import com.explore.model.member.Oauth;
import com.explore.model.member.vo.MemberOauthView;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@Service
public class MemberOauthViewService extends ServiceImpl<MemberOauthViewMapper, MemberOauthView> {
	private final static Logger logger=LoggerFactory.getLogger(MemberOauthViewService.class);
	@Autowired
	ObjectRedisTemplate objectRedisTemplate;
public MemberOauthView selectOne(MemberOauthView memberVo) {
	//从缓存中获取
	Object hashGet = objectRedisTemplate.hashGet(ConstantMemRedis.MEMBER_OAUTHID, memberVo.getOauthId());
	MemberOauthView memberOauth = FastJsonTool.toJavaBean(hashGet, MemberOauthView.class);
		if (null != memberOauth) {//获取到数据直接返回
			return memberOauth;
		}else {//缓存中没有,从数据库中获取,并放入缓存
			QueryWrapper<MemberOauthView> queryWrapper = new QueryWrapper<MemberOauthView>();
			queryWrapper.eq(!StringTool.isEmpty(memberVo.getOauthId()), "OAUTH_ID", memberVo.getOauthId());
			MemberOauthView selectOne = this.baseMapper.selectOne(queryWrapper );
			objectRedisTemplate.hashPut(ConstantMemRedis.MEMBER_OAUTHID, selectOne.getOauthId(), selectOne);	
			return selectOne;
		}
	 
}
/**
 * 登录校验
 * @param requestMsg
 * @return
 */
public ResponseMessage selectMemberOauthOne(RequestMessage requestMsg) {
	ResponseMessage responseMessage = ResponseMessage.success();
	try {
		JSONObject jsonObject = requestMsg.getBody().getContent();
		MemberOauthView mem = jsonObject.toJavaObject(MemberOauthView.class);
		MemberOauthView selectOne = this.selectOne(mem);
		responseMessage.setResultData(selectOne);
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
//修改密码
	@Transactional
	public ResponseMessage updatePasswd(RequestMessage requestMsg) {
		ResponseMessage responseMessage = ResponseMessage.success();
		try {
			JSONObject jsonObject = requestMsg.getBody().getContent();
			MemberOauthView memberVo = jsonObject.toJavaObject(MemberOauthView.class);
			//1.根据oauthId查询对应账号信息
			MemberOauthView selectOne = this.selectOne(memberVo);
			if (null != selectOne) {
				//修改密码
				String salt = StringTool.getUuid();
				String sha512Hash = CryptoUtil.sha512Hash(memberVo.getCredential(), salt, CryptoUtil.HASHITERATIONS_DEFAULT);
				selectOne.setCredential(sha512Hash);
				selectOne.setPasswd(salt);
				this.baseMapper.updateById(memberVo);
				//清除缓存
				objectRedisTemplate.hashDel(ConstantMemRedis.MEMBER_OAUTHID, selectOne.getOauthId());
			}
			
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
