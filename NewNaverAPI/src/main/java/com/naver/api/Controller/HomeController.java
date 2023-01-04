package com.naver.api.Controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.security.SecureRandom;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.api.Login.NaverLoginResoruces;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) throws UnsupportedEncodingException {
		
		String clientId = NaverLoginResoruces.getClientid();
		String redirectURI = URLEncoder.encode(NaverLoginResoruces.getCallbackurl(), "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
				+ "&client_id=" + clientId
				+"&state=" + state
				+ "&redirect_uri=" + redirectURI;
		
		model.addAttribute("apiURL", apiURL);
		session.setAttribute("state", state);
		
		return "home";
	}
	
	@GetMapping("/callback")
	public String callback(HttpServletRequest request, HttpSession session) throws Exception{
		
		String clientId = NaverLoginResoruces.getClientid();
		String clientSecret  = NaverLoginResoruces.getClientsecret();
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String redirectURI = URLEncoder.encode(NaverLoginResoruces.getCallbackurl(), "UTF-8");
		
		String apiURL = "https://openapi.naver.com/v1/nid/me"
				+"Authorization: Bearer";
		
		return "home";
	}
}
