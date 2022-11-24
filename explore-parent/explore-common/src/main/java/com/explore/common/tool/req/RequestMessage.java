package com.explore.common.tool.req;

public class RequestMessage {
	private RequestBody body;
	private RequestHead head;
	public RequestBody getBody() {
		return body;
	}
	public void setBody(RequestBody body) {
		this.body = body;
	}
	public RequestHead getHead() {
		return head;
	}
	public void setHead(RequestHead head) {
		this.head = head;
	}
}
