package com.explore.common.resp;
@Deprecated
public class ResultMsg<T> {
private String code;
private String msg;
private T data;
public ResultMsg(String code, String msg) {
	this.code = code;
	this.msg = msg;
}
public ResultMsg(String code, String msg, T data) {
	this.code = code;
	this.msg = msg;
	this.data = data;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
public static <T> ResultMsg<T> success(){
	return new ResultMsg<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
	
}
public static <T> ResultMsg<T> success(T object){
	return new ResultMsg<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),object);
	
}
public static <T> ResultMsg<T> fail(){
	return new ResultMsg<T>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg());
	
}
}
