package com.explore.common.util;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.explore.common.ao.SesessionUser;
import com.explore.common.req.RequestBody;
import com.explore.common.req.RequestHead;
import com.explore.common.req.RequestMessage;

public class HttpDataUtil {

	public static RequestMessage postData(JSONObject content, HttpServletRequest request) {
		RequestMessage requestMessage = new RequestMessage();
		RequestHead head = new RequestHead();
		if(null!=request) {
			head.setRemoteAddr(HttpDataUtil.getRemoteHost(request));
		}		 
		requestMessage.setHead(head);
		RequestBody body = new RequestBody();
		SesessionUser sessionUser = SessionUtil.getSessionUser();
		if (null != sessionUser) {
			body.setUid(sessionUser.getUid());
			body.setNickname(sessionUser.getNickname());
			body.setAvatar(sessionUser.getAvatar());
			// body.setOauthType(sessionUser.getOauthType());
		}
		body.setContent(content);
		requestMessage.setBody(body);

		return requestMessage;
	}

	/**
	 * 获取IP
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public static String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
}
