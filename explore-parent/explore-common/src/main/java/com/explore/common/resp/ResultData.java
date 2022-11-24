package com.explore.common.resp;

import java.util.HashMap;
@Deprecated
public class ResultData {
	private String resultCode;
	private String resultMsg;
	private HashMap<String, Object> returnResult;
	public ResultData(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}
	public ResultData(String resultCode, String resultMsg, HashMap<String, Object> returnResult) {
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
	public HashMap<String, Object> getReturnResult() {
		return returnResult;
	}
	public void setReturnResult(HashMap<String, Object> returnResult) {
		this.returnResult = returnResult;
	}
	public static ResultData success() {
		return new ResultData(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
	}
	public static ResultData success(HashMap<String, Object> data) {
		return new ResultData(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),data);
	}
	public static ResultData fail() {
		return new ResultData(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg());
	}
	
}
