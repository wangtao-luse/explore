package com.explore.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.constant.ConstantSys;
import com.explore.common.exception.BaseException;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.common.tool.StringTool;
import com.explore.member.persist.LoginListMapper;
import com.explore.model.member.LoginList;

/**
 * <p>
 * 登录记录表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@Service
public class LoginListService extends ServiceImpl<LoginListMapper, LoginList> {
	private final static Logger logger=LoggerFactory.getLogger(LoginListService.class);
	/**
	 * 登录记录查询
	 * @param requestMsg
	 * @return
	 */
public ResponseMessage selectLoginList(RequestMessage requestMsg) {
	ResponseMessage responseMessage = ResponseMessage.success();
	try {
		LoginList po = requestMsg.getBody().getContent().getJSONObject(ConstantSys.SYS_REQ_PO).toJavaObject(LoginList.class);
		JSONObject pagePo = requestMsg.getBody().getContent().getJSONObject(ConstantSys.SYS_REQ_PAGE);
		QueryWrapper<LoginList> queryWrapper = new QueryWrapper<LoginList>();
		queryWrapper.eq(!StringTool.isEmpty(po.getOauthId()), "OAUTH_ID", po.getOauthId());
		if (pagePo != null) {
			Page page = pagePo.toJavaObject(Page.class);
			IPage selectPage = this.baseMapper.selectPage(page, queryWrapper );
			responseMessage.setResultData(selectPage);
		}else {
			List selectList = this.baseMapper.selectList(queryWrapper);
			responseMessage.setResultData(selectList);
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
/**
 * 登录记录插入
 * @param requestMsg
 * @return
 */
@Transactional
public ResponseMessage insertLoginList(RequestMessage requestMsg) {
	ResponseMessage responseMessage = ResponseMessage.success();
	try {
		LoginList po = requestMsg.getBody().getContent().toJavaObject(LoginList.class);
		this.baseMapper.insert(po);
		
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
