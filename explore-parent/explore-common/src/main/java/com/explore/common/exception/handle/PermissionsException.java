package com.explore.common.exception.handle;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.explore.common.constant.ConstantMem;
import com.explore.common.resp.ResponseMessage;

@ControllerAdvice
public class PermissionsException {
/**
 * 无权限返回提示信息
 * @param ex
 * @return
 */
@ResponseBody
@ExceptionHandler(UnauthorizedException.class)
public ResponseMessage unauthorizedException(Exception ex) {
	return ResponseMessage.fail(ConstantMem.MEM_UNAUTHORIZED);
}
/**
 * 权限认证失败返回提示信息
 * @param ex
 * @return
 */
@ResponseBody
@ExceptionHandler (AuthorizationException.class)
public ResponseMessage  authorizationException(Exception ex) {
	return ResponseMessage.fail(ConstantMem.MEM_AUTHORIZATION);
}
}
