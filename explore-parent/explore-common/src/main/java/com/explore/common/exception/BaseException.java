package com.explore.common.exception;

public class BaseException extends RuntimeException {
private static final long serialVersionUID = 1L;
private String message;
public BaseException() {}
public BaseException(String message) {
	this.message = message;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}
