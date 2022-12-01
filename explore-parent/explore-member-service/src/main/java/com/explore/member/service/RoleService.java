package com.explore.member.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.constant.ConstantSys;
import com.explore.common.exception.BaseException;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.member.persist.RoleMapper;
import com.explore.model.member.Role;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {
	private final static Logger logger=LoggerFactory.getLogger(RoleService.class);
	/**
	 * 角色列表查询
	 * @param requestMsg
	 * @return
	 */
	public ResponseMessage selectMemRoleList(RequestMessage requestMsg) {
		ResponseMessage responseMessage = ResponseMessage.success();
		try {
			 JSONObject jsonObject = requestMsg.getBody().getContent();
			 String uid = jsonObject.getString("uid");
			Set<String> selectMemRoleList = this.baseMapper.selectMemRoleList(uid);
			responseMessage.setResultData(selectMemRoleList);
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
