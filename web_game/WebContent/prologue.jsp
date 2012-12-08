<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script src="js/jquery-1.8.2.min.js"></script>
<link href="stylesheets/prolog.css" rel="stylesheet" type="text/css">
<title>game</title>
</head>
<body>

<div id=wrap style="padding-left: 20px; padding-top: 10px">

	<div id=content style="
	opacity:0.9;filter:alpha(opacity=90);
	background-image: url('images/page.png');
	background-repeat: no-repeat;
	
	
	height:700px; ">
	<div id=introImage style="height: 300px">
	</div>
	<div id=introContent1 class="hide" style="display: block">
	한 외진 숲 속에 괴짜 마법사가 사는 탑이 있었습니다. 혼자 별에게나 빌 법한 ‘소원을 이뤄준다’는 고대의 마법을 얻으려는 그 괴짜는, 높은 탑에서 나오지 않은 채, 10년째 연구에만 몰두하고 있었습니다. 숲을 지나는 사람들은 말도 안 되는 것에 매달려 인생을 썩히는 그를 멍청하다고 했지만 그는 개의치 않아 했습니다. 
	</div>
	<div id=introContent2 class="hide">
	어느 날, 숲을 지나가던 한 여행가는 탑의 맨 꼭대기에 붉은 번개가 내리치는 모습을 보고는 사람들에게 알렸습니다. 사람들의 호기심을 불러온 이 소문에 모험가들과 마법사들은 진상을 조사하기 위해 나섰습니다. 멀리서 관측해본 마법사들은 하나같이 탑의 맨 꼭대기에서 엄청난 마력이 느껴진다고 말했습니다. 마치 정말 별이라도 떨어진 듯이.	</div>
	<div id=introContent3 class="hide">
	마법사들의 말에 의하면, 이 정도의 마력은 정말 무엇이든 이루어 줄 수 있을 지도 모른다고 말합니다. 이 조사결과는 많은 사람들의 흥미를 불러일으켰습니다. 강한 마력과 고대의 신비를 얻으려는 마법사들, 귀한 물건을 얻으려는 모험가들, 강한 힘을 얻으려는 싸움꾼들… 등등 다양한 사람들이 자신만의 목적을 위해 숲 속의 탑을 향합니다. 그 사람들 속에는 당신 또한 포함되어있습니다. 누구보다도 먼저 탑의 보물을 얻기 위해, 당신은 가장 먼저 꼭대기에 올라야 할 것입니다.
	</div>
	<div id="button">
	<button id="next">다음</button></div>
	</div>
	</div>
		
	

</body>
<script type="text/javascript">
var intro=1;
var setvisable=0;
$(function(){
	if(setvisable==0){
		setvisable=1;
		$(".hide").hide();
		$('#introContent'+intro).fadeIn();
	}
	$("#next").click(function() {
		if (intro<3) {
			
			$('#introContent'+intro).fadeOut();
			intro++;
			$('#introContent'+intro).fadeIn();
		}
		return false;
	});
});
</script>
</html>