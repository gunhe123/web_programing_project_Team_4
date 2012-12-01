<%@ page language="java" contentType="text/html;charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
<meta charset="utf-8">	
<title>마법사의 탑 -web game</title>
<link href="stylesheets/main.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body>	
<div id="wrap">	
  <div id="top_logo">
    <a href="user?op=main"><img src="images/Mario.png" alt="Web Game Logo"></a>
  </div>
  <div id="content">
    <jsp:include page="share/sidebar.jsp"></jsp:include>
    <div id="main_content">
      <jsp:include page="share/menubar.jsp"></jsp:include>
      <div class="main_section" id="notice">
      <h1>공지 사항</h1>
      <ul>
        <li>
          <div class="article">
          (웹 게임 제목)이 서비스를 개시하였습니다.
          </div>
          <span class="date">등록일: 2012.11.10</span>
        </li>
        <li>
          <div class="article">
          서비스 개시 기념 이벤트를 시작합니다. 많은 참여 부탁드립니다.
          </div>
          <span class="date">등록일: 2012.11.10</span>
        </li>
      </ul>
      </div>
      <div class="main_section" id="free_board">
      <h1>자유 게시판</h1>
      <ul>
        <li>
          <div class="article">
          2층까지 쉽게 올라가는 법
          </div>
          <span class="author">by firstuser9028</span>  
          <span class="date">등록일: 2010.11.10</span>
        </li>
        <li>
          <div class="article">
          (웹 게임 제목)의 아이템 총 정리
          </div>
          <span class="author">by seconduser3011</span> 
          <span class="date">등록일: 2010.11.10</span>
        </li>
      </ul>
      </div>
    </div>
  </div>	
</div>	
</body>
</html>