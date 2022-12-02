package com.explore.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.explore.common.ao.SesessionUser;



public class SessionUtil {
	private final static Logger logger=LoggerFactory.getLogger(SessionUtil.class);
	//权限key
    public static final String SESSION_PERMISSION="session_permission";
    public static final String SESSION_VISIT_NAME = "session_visit_name";
    
	public static Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			return subject.getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static SesessionUser getSessionUser(){
		SesessionUser currentUser = null;
		try {
			Subject subject = SecurityUtils.getSubject();
			logger.info("SessionUtil getSessionUser subject");
			if (null!=subject ) {
				PrincipalCollection principalCollection = subject.getPrincipals();
				if ( null!=principalCollection && !principalCollection.isEmpty()) {
					 Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
					 String jsonString = JSONObject.toJSONString(primaryPrincipal);
					 logger.info("jsonString "+jsonString);
					 currentUser = JSONObject.parseObject(jsonString, SesessionUser.class);
				}
			}
		} catch (Exception e) {
			logger.info("获取登录对象的时候出现异常:"+e.getMessage());
		}
		return currentUser;
	}

	
	/**
	 * 获取sessionId
	 * @return
	 */
	public static String getSessionId() {
		String sessionId="";
		try {
			Subject subject = SecurityUtils.getSubject();
			sessionId=subject.getSession().getId().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionId;
	}
	
}
