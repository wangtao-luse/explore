package com.explore.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.constant.ConstantSys;
import com.explore.common.exception.BaseException;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.member.persist.RightDetailMapper;
import com.explore.model.member.RightDetail;
import com.explore.model.member.vo.MemberOauthView;

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
	private final static Logger logger=LoggerFactory.getLogger(OauthService.class);
/**
 * 查看当前用户的权限
 * @param requestMsg
 * @return
 */
public ResponseMessage selectMeMRightDetailList(RequestMessage requestMsg) {
	ResponseMessage responseMessage = ResponseMessage.success();
	try {
		JSONObject jsonObject = requestMsg.getBody().getContent();
		String uid = jsonObject.getString("uid");
		List<RightDetail> memList = this.baseMapper.selectMeMRightDetailList(uid);
		responseMessage.setResultData(memList);
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
