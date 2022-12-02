package com.explore.common.req;

import com.alibaba.fastjson.JSONObject;

public class RequestBody {
private JSONObject content;
private String uid;
private String nickname;
private String avatar;

public JSONObject getContent() {
	return content;
}

public void setContent(JSONObject content) {
	this.content = content;
}

public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public String getAvatar() {
	return avatar;
}

public void setAvatar(String avatar) {
	this.avatar = avatar;
}

}
