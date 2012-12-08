<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script src="js/jquery-1.8.2.min.js"></script>

<link href="stylesheets/gameWindow.css" rel="stylesheet" type="text/css">
<title>game</title>
</head>
<body>

	<div id=wrap>
		<div id=main_game  style="background-image: url('images/12.jpg');
		 background-repeat: no-repeat; background-position: right bottom;" >
		<div id=gamelabel>마법사의 탑</div>
		<div id=밀어내기></div>
			<div id=character_select>
		
			<table border="1">
			<c:if test="${playerchar==null}">
			<div id="charnono">
				<p>캐릭터가 없습니다.</p> 게임을 시작하려면 캐릭터를 생성하세요.<br/>
				</div>
				<input type="button" value="케릭터 생성" onclick="location.href='game?op=makechar'"> 
			</c:if>
			<c:if test="${playerchar!=null}">
			<tr>
					<td>이름 </td>
					<td><c:out value="${playerchar.name}"/></td>
					</tr>
					<tr>
					<td>레벨 </td>
					<td><c:out value="${playerchar.level}"/></td>
					</tr>
					<tr>
					<td>체력</td>
					<td><c:out value="${playerchar.hp}"/></td>
					</tr>
					<tr>
					<td>마나</td>
					<td><c:out value="${playerchar.mp}"/></td>
					</tr>
					<tr>
					<td>캐릭터</td>
					<td>	
					<div id=playerchar>
					<c:if test="${playerchar.avata==1}">
					<img src="images/Man.gif" alt="남자1">
					</c:if>
					</div>
					</td>
			</tr>
			<div id=buttons>
			<input type="button" value="선택" id="Charselect" data-id="${playerchar.name}"
			 onclick="#"> 
			<input type="button" value="케릭터 삭제" id="CharDel" data-id="${playerchar.name}"
			 onclick="#"> 
			 </div>
			</c:if>
			</table>
			</div>

		</div>
		<div id=playerchat>
			
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$("#CharDel").click(function() {
		if (confirm("정말로 삭제하시겠습니까?")) {
			location = 'game?op=delete&id='+ $(this).attr('data-id');
		}
		return false;
	});
});
</script>
</html>