<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP AJAX 채팅 서비스</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<style>
	.main_title{
	font-family: 'Do Hyeon', sans-serif;
	color : white;
	}
	.nav-link{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 25px;
	margin-top: 30px;
	}
	.nav-tabs{
	background-color : #A9BCF5;
	}
	a{
	color : #000;
	}
	p{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 25px;
	}
</style>
</head>
<body>
	<nav>
	  <div class="nav nav-tabs" id="nav-tab" role="tablist">
	    <span style="margin: 30px;"><h2 class="main_title">실시간 회원제 채팅 서비스</h2></span>
	    
	    <!-- 세션 아이디가 없을 때 : 로그아웃 상태 -->
	    <a class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">메인화면</a>
	    <a class="nav-link" id="nav-friend-tab" data-bs-toggle="tab" href="#nav-friend" role="tab" aria-controls="nav-friend" aria-selected="false">친구찾기</a>
	    <a class="nav-link" id="nav-talk-tab" data-bs-toggle="tab" href="#nav-talk" role="tab" aria-controls="nav-talk" aria-selected="false">채팅방</a>
	    <a class="nav-link" id="nav-board-tab" data-bs-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-board" aria-selected="false">자유게시판</a>
	
		<!-- 세션 아이디가 있을 때 : 로그인 상태 -->
		<% if(session.getAttribute("sessionID")!=null){ %>
		<a class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">프로필</a>
		<a class="nav-link" id="nav-logouttab" data-bs-toggle="tab" href="logoutAction" role="tab" aria-controls="nav-logout" aria-selected="false">로그아웃</a>
		<% } %>
	  </div>
	</nav>
</body>
</html>