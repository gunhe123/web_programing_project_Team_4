<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원목록</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/base.css" rel="stylesheet">
	<script src="js/jquery-1.8.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>

  <div class="container">
 		
		<table class="table table-bordered table-stripped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Country</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td><a href="user?id=${user.id}"><c:out value="${user.userid}"/></a></td>
					<td><c:out value="${user.id}"/></td>
					<td><c:out value="${user.email}"/></td>
					<td><a href="user?op=update&id=${user.id}"
						class="btn btn-mini">modify</a> <a href="user?op=delete&id=${user.id}"
						class="btn btn-mini btn-danger" data-action="delete"
						data-id="${user.id}">delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table> 


		<div class="form-action">
			<a href="user?op=signup" class="btn btn-primary">Sign Up</a>
		</div>	 	
  </div>

</body>
<script>
$(function{
	$("a[data-action='delete']").click(function() {
		if (confirm("정말로 삭제하시겠습니까?")) {
			location = 'user?op=delete&id=' + $(this).attr('data-id');
		}
		return false;
	});
});
</script>
</html>