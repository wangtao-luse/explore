package com.explore.common.req;

public class RequestHead {
private String remoteAddr;//远程地址
private String localAddr;//本地地址
public String getRemoteAddr() {
	return remoteAddr;
}
public void setRemoteAddr(String remoteAddr) {
	this.remoteAddr = remoteAddr;
}
public String getLocalAddr() {
	return localAddr;
}
public void setLocalAddr(String localAddr) {
	this.localAddr = localAddr;
}
}
