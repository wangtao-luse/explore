package com.explore.common.resp;
@Deprecated
public class RespMsg {
	private String resultCode;
	private String resultMsg;
	private Object returnResult;
	public RespMsg(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}
	public RespMsg(String resultCode, String resultMsg, Object returnResult) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.returnResult = returnResult;
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
	public Object getReturnResult() {
		return returnResult;
	}
	public void setReturnResult(Object returnResult) {
		this.returnResult = returnResult;
	}
	public static RespMsg success() {
		return new RespMsg(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
	}
	public static RespMsg success(Object obj) {
		return new RespMsg(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),obj);
	}
	public static RespMsg fail() {
		return new RespMsg(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg());
	}
	
}
