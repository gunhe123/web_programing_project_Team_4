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
    <a href="webMain.jsp"><img src="images/mario.png" alt="Web Game Logo"></a>
  </div>
  <div id="content">
    <jsp:include page="share/sidebar.jsp"></jsp:include>
    <div id="main_content">
      <jsp:include page="share/menubar.jsp"></jsp:include>
      <div class="main_section" id="notice">
      <h1>회원가입</h1>
      <ul>
        <li>
          <div class="article">
          아래 정보를 기입해주십시오.
          </div>
        </li>
        <li>
         <div>
		  <form class="form-horizontal" action="user?op=signup" method="POST">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="userid">ID</label>
					<div class="controls">
						<input type="text" name="userid">
					</div>
				</div>

					<div class="control-group">
						<label class="control-label" for="pwd">Password</label>
						<div class="controls">
							<input type="password" name="pwd">
						</div>
					</div>
	
					<div class="control-group">
						<label class="control-label" for="pwd_confirm">Password Confirmation</label>
						<div class="controls">
							<input type="password" name="pwd_confirm">
						</div>
					</div>

				<div class="control-group">
					<label class="control-label" for="email">E-mail</label>
					<div class="controls">
						<input type="email" placeholder="hong@abc.com" name="email">
					</div>
				</div>

	
				
				<div class="form-actions">
					<a href="user?op=main" class="btn">돌아가기</a>
					
  						<input type="submit" class="btn btn-primary" value="가입">
  				
				</div>
			</fieldset>
		  </form>
    </div>
        </li>
      </ul>
      </div>

    </div>
  </div>	
</div>	
</body>
</html>