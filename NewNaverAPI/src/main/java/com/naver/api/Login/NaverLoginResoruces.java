package com.naver.api.Login;

public class NaverLoginResoruces {
	
	private static final String clientId = "OBRkTnC3OBfI2L2zE1E2";
	private static final String clientSecret = "YqVnwLLzKs";
	private static final String callbackURL = "http://localhost:8090/callback";
	private static final String profileURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	
	public static String getClientid() {
		return clientId;
	}
	public static String getClientsecret() {
		return clientSecret;
	}
	public static String getCallbackurl() {
		return callbackURL;
	}
	public static String getProfileurl() {
		return profileURL;
	}

	
}
