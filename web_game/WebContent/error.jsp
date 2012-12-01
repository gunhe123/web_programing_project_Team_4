<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="alert alert-error">
 		 아래와 같은 오류로 등록이 불가능 합니다.
          <c:forEach var="msg" items="${errorMsgs}">
            <li>${msg}</li>
          </c:forEach>
          <input type="button" value="돌아가기 " onclick="location.href='user?op=signin'";> 

    </div>
  </div>

  
</body>
</html>
