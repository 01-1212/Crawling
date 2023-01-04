package com.naver.api.Login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.http.HttpRequest;

import javax.servlet.http.HttpSession;

public class NaverOauth {

	public String getAuthorization(HttpSession session) {
		
		String state = generatedRandomString();
		return null;
	}

	private String generatedRandomString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
