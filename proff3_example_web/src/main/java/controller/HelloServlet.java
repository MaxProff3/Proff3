package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder("<html>");
       	
        sb.append("<head>");
        sb.append("<title>������ �������</title>");
        sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        sb.append("</head>");
        sb.append("<body>");
        
        sb.append("<h2>��� ������ ���������� � �����! <h2>");
        
        sb.append("</body>");
        sb.append("</head>");
        
        response.setContentType("text/html; charset=UTF-8");
    	response.getWriter().print(sb.toString());
    }
}

