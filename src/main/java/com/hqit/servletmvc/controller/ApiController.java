package com.hqit.servletmvc.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hqit.servletmvc.annotation.Controller;
import com.hqit.servletmvc.annotation.Path;

@Controller
public class ApiController 
{
	@Path("/api/v1/user/get_user_info")
	public void processUserInfo(HttpServletRequest req, HttpServletResponse resp)throws Exception
	{
		resp.setContentType("application/json");
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(getUserInfo());
		out.close();
	}
	
	private String getUserInfo()
	{
		Map<String, String> user = new HashMap<>();
		user.put("id", "1");
		user.put("phone", "10086");
		user.put("name", "CMCC");
		user.put("web_site", "http://www.10086.cn");
		Gson g = new Gson();
		return g.toJson(user);
	}
}
