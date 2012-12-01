<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" import="java.util.*" %>
<%

	// DB 접속을 위한 준비
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		out.println("예외qw3");
	String dbUrl = "jdbc:mysql://localhost:3306/web_game";
	String dbUser = "id001";
	String dbPassword = "pwd001";
	out.println("예외123123");
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	
	stmt = conn.createStatement();
	rs=stmt.executeQuery("select * from character");
	
	while(rs.next()){
		out.println("아이디를 내놔라"+rs.getString("name"));
	}
	} catch (SQLException e) {
		
		out.println("예외처리가 되어버려쪙!");
	} finally {
		// 무슨 일이 있어도 리소스를 제대로 종료
		if (rs != null) try{rs.close();} catch(SQLException e) {}
		if (stmt != null) try{stmt.close();} catch(SQLException e) {}
		if (conn != null) try{conn.close();} catch(SQLException e) {}
	}
	
%>