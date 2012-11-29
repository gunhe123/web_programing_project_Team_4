package web_servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_java.User;
import web_java.UserDAO;

//@WebServlet("/user")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException{
		String actionUrl = "";
		
		try{
			List<User> users=UserDAO.getUserlist();
			request.setAttribute("users",users);
			actionUrl="testIndex.jsp";
		}catch(SQLException|NamingException e){
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
			actionUrl = "error.jsp";
		}finally{
			RequestDispatcher dispatcher = request.getRequestDispatcher(actionUrl);
			dispatcher.forward(request,  response);
		}
	}
}
