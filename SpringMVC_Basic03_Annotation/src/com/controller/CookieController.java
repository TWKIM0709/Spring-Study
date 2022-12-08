package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie/")
public class CookieController {
	
	@RequestMapping("make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth", "1004"));
		return "cookie/CookieMake";
	}
	@RequestMapping("view.do")
	public String view(@CookieValue(value="auth",defaultValue = "1007") String auto) {
		System.out.println("클라이언트에서 read한 cookie값 : " + auto);
		return "cookie/CookieView";
	}
}
