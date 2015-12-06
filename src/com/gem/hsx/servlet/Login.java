package com.gem.hsx.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.hsx.daoimpl.UserDaoImpl;
import com.gem.hsx.json.JsonUtil;
import com.gem.hsx.json.WriteJson;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    PrintWriter out=response.getWriter();
	    
//	    WriteJson wj = new WriteJson();
//	    List<String> responseList = new ArrayList<String>();
//	    responseList.add("")
//	    
//	    String result = wj.getJsonData(responseList);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		System.out.println("username is "+username+",passwoord is "+password);
		boolean b=userDaoImpl.login(username,password);
		if (b) 
		{
			out.write("{\"status\":\"yes\",\"message\":\"login sucess\"}");
//			out.write("{status:yes,message:login sucess}");
			
		}
		else 
		{
			out.write("LOGIN_FAIL");
		}
		out.flush();
		out.close();
	}

}
