package com.hqit.servletmvc.controller;

/**
 * 这个controller演示的是基于约定优于配置的用法
 * @author ly
 *
 */
public class PaymentController 
{
	
	/**
	 * 访问路径为 /pay/index
	 * @return
	 * @throws Exception
	 */
	public String indexAction() throws Exception
	{
		return "/user/index.jsp";
	}
	
	/**
	 * 访问路径为 /pay/pay
	 * @return
	 * @throws Exception
	 */
	public String payAction() throws Exception
	{
		return "/user/pay.jsp";
	}
	
}
