<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 게시판 사이트</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
	
	<style>
	.loginWrapper{
	display: flex;
	justify-content: center;
	text-align: center;
	margin-top: 200px;
	}
	input{
	width: 300px;
	height: 40px;
	}
	.find{
	font-size: 12px;
	}
	.btn{
	width: 300px;
	}
	</style>
	
	<script type="text/javascript">
		

	</script>
	
</head>
<body>
<jsp:include page="/WEB-INF/views/Header.jsp"/>


<div class="loginWrapper">
<div class="loginDiv">

<% if(session.getAttribute("sessionID")==null){ %>
	<form action="loginAction" method="post">
	
	<p>로그인</p>
		<table>	
			<tr>
				<td><input type="text" name="id" id="id" placeholder="아이디를 입력해주세요."></td>
			</tr>
			<tr>
				<td><input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요."></td>	
			</tr>
			<tr>
				<td><a href="#" class="find">아이디 찾기 |</a> <a href="#" class="find">비밀번호 찾기</a></td>
			</tr>
			<tr>
				<td>
					<div style="margin-top: 20px;"><button type="submit" class="btn btn-primary">로그인</button></div>
				</td>
			</tr>
			<tr>
				<td>
					<div style="margin-top: 10px;"><button type="button" id="joinbtn" class="btn btn-primary" onclick="location.href='joinForm'">회원가입</button></div>
				</td>
			</tr>
	
		</table>
	</form>
	<% } else {
	String id = (String)session.getAttribute("sessionID");
	%>
		<h1><%=id%>님 계정으로 로그인 되었습니다.</h1>
	<% } %>
</div>
</div>
<jsp:include page="/WEB-INF/views/Footer.jsp"/>		
</body>
</html>