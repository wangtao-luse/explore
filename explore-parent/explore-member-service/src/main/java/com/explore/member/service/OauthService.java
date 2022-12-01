package com.explore.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.constant.ConstantSys;
import com.explore.common.encryption.CryptoUtil;
import com.explore.common.exception.BaseException;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.common.tool.StringTool;
import com.explore.member.persist.OauthMapper;
import com.explore.model.member.Oauth;

/**
 * <p>
 * 会员认证表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-11-30
 */
@Service
public class OauthService extends ServiceImpl<OauthMapper, Oauth> {
	
	private final static Logger logger=LoggerFactory.getLogger(OauthService.class);
	public Oauth selectOne(Oauth oauth) {
		QueryWrapper<Oauth> queryWrapper = new QueryWrapper<Oauth>();
		queryWrapper.eq(!StringTool.isEmpty(oauth.getOauthId()), "OAUTH_ID", oauth.getOauthId());
		Oauth selectOne = this.baseMapper.selectOne(queryWrapper );
		return selectOne;
	}
    //查看会员认证信息
	public ResponseMessage selectOauthOne(RequestMessage requestMsg) {
		ResponseMessage responseMessage = ResponseMessage.success();
		try {
			JSONObject jsonObject = requestMsg.getBody().getContent();
			Oauth oauth = jsonObject.toJavaObject(Oauth.class);
			Oauth selectOne = this.selectOne(oauth);
			responseMessage.setResultData(selectOne);
		} catch (BaseException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		return responseMessage;
		
	}
	//修改密码
	@Transactional
	public ResponseMessage updatePasswd(RequestMessage requestMsg) {
		ResponseMessage responseMessage = ResponseMessage.success();
		try {
			JSONObject jsonObject = requestMsg.getBody().getContent();
			Oauth oauth = jsonObject.toJavaObject(Oauth.class);
			QueryWrapper<Oauth> queryWrapper = new QueryWrapper<Oauth>();
			queryWrapper.eq(!StringTool.isEmpty(oauth.getOauthId()), "OAUTH_ID", oauth.getOauthId());
			Oauth selectOne = this.baseMapper.selectOne(queryWrapper );
			String salt = StringTool.getUuid();
			String sha512Hash = CryptoUtil.sha512Hash(oauth.getCredential(), salt, CryptoUtil.HASHITERATIONS_DEFAULT);
			selectOne.setCredential(sha512Hash);
			selectOne.setPasswd(salt);
			this.baseMapper.updateById(selectOne);
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
