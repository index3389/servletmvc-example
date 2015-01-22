package com.hqit.servletmvc.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import com.hqit.servletmvc.annotation.Controller;
import com.hqit.servletmvc.annotation.Path;
import com.hqit.servletmvc.entry.MultipartBean;
import com.hqit.servletmvc.multipart.MultipartHandler;

/**
 * 这个controller演示的是基于注解的用法
 * @author ly
 *
 */
@Controller
public class BookController
{
	@Path("/upload/default")
	public String index()throws Exception
	{
		return "/user/index.jsp";
	}
	
	@Path("/upload/index")
	public String upload(MultipartHandler handler,HttpServletRequest request)throws Exception
	{
		String dir = request.getSession().getServletContext().getRealPath("/upload");
		
		MultipartBean bean = handler.getMultipartBean("imageFile1");
		
		if(bean != null)
		{
			String fileName = bean.getFileName();
			
			InputStream input = bean.getInputStream();
			
			OutputStream out = new FileOutputStream(dir + "/" + fileName);
			
			byte[] b = new byte[1024];
			
			int upload = 0;
			
			while((upload = input.read(b)) > 0)
			{
				out.write(b,0,upload);
			}
			
			out.close();
			input.close();
			
			request.setAttribute("imgpath",fileName);
		}
		
		return "/user/index2.jsp";
	}
	
}
