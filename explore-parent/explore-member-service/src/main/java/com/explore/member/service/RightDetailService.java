package com.explore.member.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.constant.ConstantSys;
import com.explore.common.exception.BaseException;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.common.tool.StringTool;
import com.explore.member.persist.RightDetailMapper;
import com.explore.model.member.RightDetail;

/**
 * <p>
 * 权限主表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@Service
public class RightDetailService extends ServiceImpl<RightDetailMapper, RightDetail> {
	private final static Logger logger=LoggerFactory.getLogger(RightDetailService.class);
/**
 * 查看当前用户的权限
 * @param requestMsg
 * @return
 */
public ResponseMessage selectMemRightDetailList(RequestMessage requestMsg) {
	ResponseMessage responseMessage = ResponseMessage.success();
	try {
		JSONObject jsonObject = requestMsg.getBody().getContent();
		String uid = jsonObject.getString("uid");
		if(StringTool.isEmpty(uid)) {//从session中获取
			uid = requestMsg.getBody().getUid();
		}
		Set<String> memList = this.baseMapper.selectMemRightDetailList(uid);
		responseMessage.setResultData(memList);
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
 * 查看可以匿名访问的url
 * @param requestMsg
 * @return
 */
public ResponseMessage selectAnonUrl(RequestMessage requestMsg) {
	ResponseMessage responseMessage = ResponseMessage.success();
	try {
		 List<String> selectAnonUrl = this.baseMapper.selectAnonUrl();
		responseMessage.setResultData(selectAnonUrl);
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
