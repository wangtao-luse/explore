package com.explore.common.resp;

import java.io.Serializable;

import com.explore.common.tool.StringTool;

public class ResponseMessage  implements Serializable{
	private static final long serialVersionUID = 1L;
	private String resultCode;
	private String resultMsg;
	private Object resultData;
	public ResponseMessage() {}
	public ResponseMessage(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}
	public ResponseMessage(String resultCode, String resultMsg, Object resultData) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultData = resultData;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	public static ResponseMessage success() {
		return new ResponseMessage(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
	}
	public static ResponseMessage success(Object object) {
		return new ResponseMessage(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),object);
	}
	public static ResponseMessage fail() {
		return new ResponseMessage(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg());
	}
	public static ResponseMessage fail(String msg) {
		return new ResponseMessage(ResultCode.FAIL.getCode(), msg);
	}
	public static boolean successed(ResponseMessage respMsg) {
		return !StringTool.isEmpty(respMsg) && ResultCode.SUCCESS.equals(respMsg.getResultCode());
	}
}
