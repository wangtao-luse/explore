package com.explore.member.service;

import java.util.List;

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
import com.explore.common.tool.StringTool;
import com.explore.member.persist.GroupMapper;
import com.explore.model.member.Group;
import com.explore.model.member.LoginList;

/**
 * <p>
 * 会员组表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@Service
public class GroupService extends ServiceImpl<GroupMapper, Group> {
	private final static Logger logger=LoggerFactory.getLogger(GroupService.class);
	/**
	 * 用户组列表查询
	 * @param requestMsg
	 * @return
	 */
	public ResponseMessage selectLoginList(RequestMessage requestMsg) {
		ResponseMessage responseMessage = ResponseMessage.success();
		try {
			Group po = requestMsg.getBody().getContent().getJSONObject(ConstantSys.SYS_REQ_PO).toJavaObject(Group.class);
			JSONObject pagePo = requestMsg.getBody().getContent().getJSONObject(ConstantSys.SYS_REQ_PAGE);
			QueryWrapper<Group> queryWrapper = new QueryWrapper<Group>();
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
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new BaseException(ConstantSys.SYS_ERROR);
		}
		return responseMessage;
	}
}
