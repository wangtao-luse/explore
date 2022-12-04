package com.explore.common.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class PermissionsException {
@ResponseBody
@ExceptionHandler(UnauthorizedException.class)
public String unauthorizedException(Exception ex) {
	return "无权限";
}
@ResponseBody
@ExceptionHandler (AuthorizationException.class)
public String  authorizationException(Exception ex) {
	return "权限认证失败";
}
}
