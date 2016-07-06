package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ContentService;
import service.ContentServiceImple;

@WebServlet("/content")
public class ContentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userName = (String)session.getAttribute("userName");
		if(userName==null){
			resp.sendRedirect("main");
		} else {
			ContentService serviceContent = new ContentServiceImple();
			req.setAttribute("contents", serviceContent.getAllcontents());
		
			String str = "<option value=1>Car</option>";
			str += "<option value=2>House</option>";
			req.setAttribute("selectBlock1", str);
			
			req.getRequestDispatcher("jsp/content.jsp").forward(req, resp);
		}
	}

}
