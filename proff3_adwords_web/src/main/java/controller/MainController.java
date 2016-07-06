package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("nLogin");
		String pass = req.getParameter("nPass");
		String logout = req.getParameter("logout");
		
		HttpSession session = req.getSession();
		String userName = (String)session.getAttribute("userName");
		System.out.println("userName="+userName+", logout="+logout);

		// logout
		if(logout!=null && logout.equals("logout_value")){
			System.out.println("MainController, logout");
			session.setAttribute("userName", null);
			req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
			return;
		}
		
		if(login!= null){// In by form
			
			// userService		
			if (login.equals(pass)) { // is login and pass correct
				System.out.println("MainController, login correct");
				String name = "Name_" + login;
				session.setAttribute("userName", name);
				resp.sendRedirect("content");
			} else {
				System.out.println("MainController, login incorrect");
				req.setAttribute("error", "Incorrect login or pass!");
				req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
			}
		} else {// In by openPage
			System.out.println("MainController, openPage, userName="+userName);
			req.setAttribute("userName", userName);			
			req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
		}

	}

}
