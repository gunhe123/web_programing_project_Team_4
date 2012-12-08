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

import web_java.CharDAO;
import web_java.UserDAO;
import web_java.character;



@WebServlet("/game")
public class charServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6717906924013902238L;
	public charServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op=req.getParameter("op");
		String actionUrl="";
		HttpSession session=req.getSession(true);
		// TODO Auto-generated method stub
	
		if(session.getAttribute("S_Id")!=null){
			String userid=(String) session.getAttribute(("S_Id"));
			
			try {
				if(op==null || op.equals("main")){
					
						actionUrl="GameMain.jsp";
					character charty=CharDAO.findById(userid);
					if(charty!=null){
						req.setAttribute("playerchar",charty);
					}else{
						req.setAttribute("playerchar",null);
					}
				
				}else if(op.equals("makechar")){
					actionUrl="makeCharacter.jsp";
				}else if(op.equals("delete")){
					String name=req.getParameter("id");
					CharDAO.remove(name);
					actionUrl="game?op=main";
				}else{
					actionUrl="user";
				}
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else{
			actionUrl="user";
		}
		RequestDispatcher rd=req.getRequestDispatcher(actionUrl);

		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op=req.getParameter("op");
		String actionUrl="";
		List<String> errorMsgs=new ArrayList<>();
		HttpSession session=req.getSession(true);
		String userid=(String) session.getAttribute(("S_Id"));
		if(op.equals("signup")){
			try {
				CharDAO.create(new character(userid,
						req.getParameter("name"),req.getParameter("wish"),
						Integer.parseInt(req.getParameter("hp")),Integer.parseInt(req.getParameter("mp")),
						Integer.parseInt(req.getParameter("attack")),Integer.parseInt(req.getParameter("deffence"))
						, Integer.parseInt(req.getParameter("avata"))));
				actionUrl="game?op=main";
			} catch (NumberFormatException e) {
				errorMsgs.add(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				errorMsgs.add(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				errorMsgs.add(e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(errorMsgs.isEmpty()){
				actionUrl="prologue.jsp";
			}else{
				req.setAttribute("errorMsgs", errorMsgs);
				actionUrl = "error.jsp";
			}
		}else{
			actionUrl="user";
		}
		RequestDispatcher rd=req.getRequestDispatcher(actionUrl);

		rd.forward(req, resp);
	}
}
