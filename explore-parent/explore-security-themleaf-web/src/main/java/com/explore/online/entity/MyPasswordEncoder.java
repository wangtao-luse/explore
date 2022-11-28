package com.explore.online.entity;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.explore.common.tool.MessageDigestTool;

public class MyPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		String sha512 = MessageDigestTool.getSHA512(rawPassword.toString(), false);
		return sha512;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		String sha512 = MessageDigestTool.getSHA512(rawPassword.toString(), false);
		return false;
	}

}
