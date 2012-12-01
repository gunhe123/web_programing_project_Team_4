<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
<meta charset="utf-8">	
  <script src="js/jquery-1.8.2.min.js"></script>
</head>
<body>
<div id="sidebar">
			<div id="login_box">
	<% if (session.getAttribute("S_Id") == null){%>
	  <form class="form-horizontal" action="user?op=login" method="POST">
			<table border="1">
				<tr>
				<td>
				id
				</td>
				<td>
				<input type="text" name="id" size="7">
				</td>
				</tr>
				<tr>
				<td>
				pw
				</td>
				<td>
				<input type="password" name="pw" size="7">
				</td>
				</tr>
			</table>

 	   		<input type="submit" class="btn btn-primary" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='user?op=signin'"> 
			</form>


			<% } else { %>
			  안녕하세요. <b><%=session.getAttribute("S_Id") %></b>님<br>
			<input type="button" value="로그아웃" onclick="location.href='user?op=logout'">   
			<% } %>
			</div>
			<div id="sns">
			<h1>SNS 연동</h1>
			</div>
		</div>
		</body>
		</html>