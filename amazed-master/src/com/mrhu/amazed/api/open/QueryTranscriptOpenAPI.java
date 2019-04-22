package com.mrhu.amazed.api.open;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrhu.amazed.hibernatedata.TranscriptFactory;

public class QueryTranscriptOpenAPI extends HttpServlet {

	public QueryTranscriptOpenAPI() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	
	/**
	 * post和get处理的方式相同
	 * 支持post和get方式调用API
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * 处理请求的实体方法
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String password = request.getParameter("password");
		String result = TranscriptFactory.getTranscript(password);
		out.write(result);
		out.flush();
		out.close();
	}
	
	public void init() throws ServletException {
		
	}

}
