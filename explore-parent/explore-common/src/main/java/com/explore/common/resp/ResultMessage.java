package com.explore.common.resp;

import java.util.List;
@Deprecated
public class ResultMessage<T> {
	private Boolean success;  //请求是否成功
	private List<T> list;    //结果的集合
	private int total;     //结果的总条数
	private Object obj;////其他的对象
	public ResultMessage(Boolean success) {
		this.success = success;
	}
	public ResultMessage(Boolean success, Object obj) {
		this.success = success;
		this.obj = obj;
	}
	public ResultMessage(List<T> list, int total) {
		this.list = list;
		this.total = total;
	}	
	
	public ResultMessage(Boolean success, List<T> list, int total, Object obj) {
		this.success = success;
		this.list = list;
		this.total = total;
		this.obj = obj;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public static <T> ResultMessage<T> sucess() {
		return new ResultMessage<T>(true);
	}
	public static <T> ResultMessage<T> sucess(List<T> list) {
		return new ResultMessage<T>(list,list.size());
	}
	public static <T> ResultMessage<T> sucess(List<T> list,Object obj) {
		return new ResultMessage<T>(true,list,list.size(),obj);
	}
	public static <T> ResultMessage<T> sucess(Object obj) {
		return new ResultMessage<T>(true,obj);
	}
	public static <T> ResultMessage<T> fail() {
		return new ResultMessage<T>(false);
	}
}
