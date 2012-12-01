<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="stylesheets/gameWindow.css" rel="stylesheet" type="text/css">
<title>game</title>
</head>
<body>

	<div id=wrap>
		<div id=main_game>
		<div id=createdchar><h1>캐릭터 생성</h1>
		<form class="form-horizontal" action="game?op=signup" method="POST">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="name">name</label>
					<div class="controls">
						<input type="text" name="name">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="wish">소원</label>
					<div class="controls">
						<input type="text" name="wish">
					</div>
				</div>
					<div class="control-group">
						<label class="control-label" for="hp">hp</label>
						<div class="controls">
							<input type="range" name="hp" min="1" max="30">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="mp">mp</label>
						<div class="controls">
							<input type="range" name="mp" min="1" max="30">
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="attack">공격력</label>
						<div class="controls">
							<input type="range" name="attack" min="1" max="30">
						</div>
					</div>
	
					<div class="control-group">
					<label class="control-label" for="deffence">방어력</label>
						<div class="controls">
							<input type="range" name="deffence" min="1" max="30">
						</div>
					</div>

				
				<div class="control-group">
					<label class="control-label" for="avata">아바타</label>
						<div class="controls">
							<input type="range" name="avata" min="1" max="1">
						</div>
				</div>

	
				
				<div class="form-actions">
					<a href="game?op=main" class="btn">돌아가기</a>
					
  						<input type="submit" class="btn btn-primary" value="가입">
				</div>
			</fieldset>
		  </form>
		</div>
		
		<div id=playerchat>
			
		</div>
	</div>
</div>
</body>
</html>