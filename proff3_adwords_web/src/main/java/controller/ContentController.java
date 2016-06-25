package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContentService;
import service.ContentServiceImple;

@WebServlet("/content")
public class ContentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentService serviceContent = new ContentServiceImple();
		req.setAttribute("contents", serviceContent.getAllcontents());
		
		req.getRequestDispatcher("jsp/content.jsp").forward(req, resp);

	}

}
