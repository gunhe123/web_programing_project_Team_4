package web_servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_java.User;
import web_java.UserDAO;

@WebServlet("/user")
public class UserSerblet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6717906924013902238L;
	public UserSerblet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = req.getParameter("op");
		String saywhat="나는 나나나나나나나";
		String actionUrl="";
		try {
			if(op==null || op.equals("main")){
			List<User> users=UserDAO.getUserlist();
			req.setAttribute("userlist",users);
			actionUrl="webMain.jsp";
			}else if(op.equals("logout")){
				actionUrl="webMain.jsp";
				HttpSession session=req.getSession(true);
				session.setAttribute("S_Id",null);
			}else if(op.equals("signin")){
				actionUrl="signup.jsp";
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=req.getRequestDispatcher(actionUrl);
		req.setAttribute("say", saywhat);
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op=req.getParameter("op");
		String actionUrl="";
		String msg;
		String userid;
		String pwd;
		req.setCharacterEncoding("utf-8");
		User user = new User();
		List<String> errorMsgs = new ArrayList<String>();
		try {
			if(op.equals("login")){
				userid = req.getParameter("id");
				pwd = req.getParameter("pw");
				User temp;
				
			if((userid!=null) &&( (temp=UserDAO.findById(userid))!=null ) ){
				if(pwd.equals(temp.getPassword())){
					actionUrl="webMain.jsp";
					HttpSession session=req.getSession(true);
					session.setAttribute("S_Id",temp.getId());
				}
			}else{
				actionUrl="webMain.jsp";
				
			}
		
			}else if(op.equals("signup")){
				
				userid = req.getParameter("userid");
				pwd = req.getParameter("pwd");
				String pwd_confirm = req.getParameter("pwd_confirm");
				String email = req.getParameter("email");
				if(UserDAO.findById(userid)!=null){
					errorMsgs.add("이미 있는 아이디입니다.");
				}
				if (userid == null || userid.trim().length() == 0) {
					errorMsgs.add("ID를 반드시 입력해주세요.");
				}
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("email을 반드시 입력해주세요.");
				}
				if (pwd == null || pwd.length() < 6) {
					errorMsgs.add("비밀번호는 6자 이상 입력해주세요.");
				} 
				
				if (!pwd.equals(pwd_confirm)) {
					errorMsgs.add("비밀번호가 일치하지 않습니다.");
				}
				
				
				if(errorMsgs.isEmpty()){
					user.setEmail(email);
					user.setId(userid);
					user.setPassword(pwd);
					UserDAO.create(user);
					actionUrl = "success.jsp";
					msg = "<b>" + userid + "</b>님의 사용자 정보가 등록 되었습니다.";
					req.setAttribute("msg", msg);
					actionUrl = "success.jsp";
				}else{
					req.setAttribute("errorMsgs", errorMsgs);
					actionUrl = "error.jsp";
				}
			}else{
				actionUrl="webMain.jsp";
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			errorMsgs.add(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			errorMsgs.add(e.getMessage());
			e.printStackTrace();
		}
		
		RequestDispatcher rd=req.getRequestDispatcher(actionUrl);
		rd.forward(req, resp);
	}

}
