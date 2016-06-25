package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/ajax")
public class AjaxController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ajax doGet");
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ajax doPost");
		String str =  req.getParameter("cat");
		str += "/" + req.getParameter("text");
		System.out.println("ajax:"+str);
		
		JSONObject myJsonObj = new JSONObject();
		StringBuilder sb = new StringBuilder();
		
		myJsonObj.append("result", "ok");
		
		myJsonObj.append("catalog", "NEDVIZHON+MOST");
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJsonObj.toString());		
	}
}
