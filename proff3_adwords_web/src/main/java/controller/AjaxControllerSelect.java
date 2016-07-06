package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/ajaxSelect")
public class AjaxControllerSelect extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code =  req.getParameter("code");
		
		
		StringBuilder sb = new StringBuilder();
		if("1".equals(code)){
			sb.append("<option value='1'>BMW</option>");
			sb.append("<option value='2'>Smart</option>");
			sb.append("<option value='3'>Hyunday</option>");
			sb.append("<option value='4'>Metro</option>");
		}
		if("2".equals(code)){
			sb.append("<option value='1'>House</option>");
			sb.append("<option value='2'>Flat</option>");
			sb.append("<option value='3'>Hole</option>");
		}
		
		JSONObject myJsonObj = new JSONObject();
		
		myJsonObj.append("res", sb.toString());
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJsonObj.toString());		
	}
}
