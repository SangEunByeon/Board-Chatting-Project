<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
	<style>
	.BoardWrapper{
	display: flex;
	justify-content: center;
	text-align: center;
	}
	.BoardDiv{
	margin-top: 120px;
	width: 1000px;
	}
	</style>
	<script type="text/javascript">
	function writeForm(){
		location.href="WriteForm";
		}
	</script>
	
</head>
<body>
<jsp:include page="/WEB-INF/views/Header.jsp"/>

게시판 내용이 들어갑니다.

<div class="BoardWrapper">
	<div class="BoardDiv">
		<table class="table table-striped table-hover">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회</td>
			</tr>
			<tr>
				<td>1</td>
				<td>제목1</td>
				<td>user1</td>
				<td>2021-01-10</td>
				<td>0</td>
			</tr>
			<tr>
				<td>1</td>
				<td>제목1</td>
				<td>user1</td>
				<td>2021-01-10</td>
				<td>0</td>
			</tr>
			<tr>
				<td>1</td>
				<td>제목1</td>
				<td>user1</td>
				<td>2021-01-10</td>
				<td>0</td>
			</tr>
			<tr>
				<td>1</td>
				<td>제목1</td>
				<td>user1</td>
				<td>2021-01-10</td>
				<td>0</td>
			</tr>
		
		</table>
		<button class="btn btn-primary" onclick="writeForm()">글쓰기</button>
	</div>
</div>

<jsp:include page="/WEB-INF/views/Footer.jsp"/>		
</body>
</html>