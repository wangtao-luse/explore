package com.explore.online.connector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.common.util.HttpDataUtil;
import com.explore.member.api.MemberApi;

@Component
public class MemberConnector {
@Autowired
MemberApi memberApi;
/**
 * 查看用户信息
 * @param jsonObject
 * @param request
 * @return
 */
public ResponseMessage selectMemberOauthOne(JSONObject jsonObject,HttpServletRequest request) {
	RequestMessage requestMsg = HttpDataUtil.postData(jsonObject, request);
	return memberApi.selectMemberOauthOne(requestMsg);
}
/**
 * 获取当前用户角色
 * @param jsonObject
 * @param request
 * @return
 */
public ResponseMessage selectMemRoleList(JSONObject jsonObject,HttpServletRequest request) {
	RequestMessage requestMsg = HttpDataUtil.postData(jsonObject, request);
	return memberApi.selectMemRoleList(requestMsg);
}
/**
 * 获取当前用户权限
 * @param jsonObject
 * @param request
 * @return
 */
public ResponseMessage selectMemRightDetailList(JSONObject jsonObject,HttpServletRequest request) {
	RequestMessage requestMsg = HttpDataUtil.postData(jsonObject, request);
	return memberApi.selectMemRightDetailList(requestMsg);
}
/**
 * 查询匿名访问URL
 * @param jsonObject
 * @param request
 * @return
 */
public ResponseMessage selectAnonUrl(JSONObject jsonObject,HttpServletRequest request) {
	RequestMessage requestMsg = HttpDataUtil.postData(jsonObject, request);
	return memberApi.selectAnonUrl(requestMsg);
}

}
