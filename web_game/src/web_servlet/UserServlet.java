package web_servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import web_java.User;
import web_java.UserDAO;

/**
 * Servlet implementation class User

 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionUrl = "";
		boolean ret;
		
		String id =request.getParameter("id");
		
		/*if (op == null && id > 0) {
			op = "show";
		}*/
		
		try {
			
				
				
				List<User> users = UserDAO.getUserlist();
				request.setAttribute("users", users);

				actionUrl = "testIndex.jsp";
			
		} catch (SQLException | NamingException e) {
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
			actionUrl = "error.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(actionUrl);
		dispatcher.forward(request,  response);
		
	}


	private boolean isRegisterMode(HttpServletRequest request) {
		String method = request.getParameter("_method");
		return method == null || method.equals("POST");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean ret = false;
		String actionUrl;
		String msg;
		User user = new User();

		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String pwd_confirm = request.getParameter("pwd_confirm");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String gender = request.getParameter("gender");
		String[] favorites = request.getParameterValues("favorites");
		String favoriteStr = StringUtils.join(favorites, ",");
		
		List<String> errorMsgs = new ArrayList<String>();
		
		if (isRegisterMode(request)) {
			if (pwd == null || pwd.length() < 6) {
				errorMsgs.add("비밀번호는 6자 이상 입력해주세요.");
			} 
			
			if (!pwd.equals(pwd_confirm)) {
				errorMsgs.add("비밀번호가 일치하지 않습니다.");
			}
			user.setPassword(pwd);
		} else {
			user.setId(request.getParameter("id"));
		}

		if (userid == null || userid.trim().length() == 0) {
			errorMsgs.add("ID를 반드시 입력해주세요.");
		}
		
		if (name == null || name.trim().length() == 0) {
			errorMsgs.add("이름을 반드시 입력해주세요.");
		}
		
		if (gender == null || !(gender.equals("M") || gender.equals("F") )) {
			errorMsgs.add("성별에 적합하지 않은 값이 입력되었습니다.");
		}
		
		user.setId(userid);
		user.setEmail(email);

		try {
			if (isRegisterMode(request)) {
				ret = UserDAO.create(user);
				msg = "<b>" + name + "</b>님의 사용자 정보가 등록되었습니다.";
			} else {
				ret = UserDAO.update(user);
				actionUrl = "success.jsp";
				msg = "<b>" + name + "</b>님의 사용자 정보가 수정되었습니다.";
			}
			if (ret != true) {
				errorMsgs.add("변경에 실패했습니다.");
				actionUrl = "error.jsp";
			} else {
				request.setAttribute("msg", msg);
				actionUrl = "success.jsp";
				
			}
		} catch (SQLException | NamingException e) {
			errorMsgs.add(e.getMessage());
			actionUrl = "error.jsp";
		}
		
		request.setAttribute("errorMsgs", errorMsgs);
		RequestDispatcher dispatcher = request.getRequestDispatcher(actionUrl);
		dispatcher.forward(request,  response);
	}

}
