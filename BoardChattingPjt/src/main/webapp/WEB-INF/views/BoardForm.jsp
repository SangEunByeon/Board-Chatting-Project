<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	p{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 30px;
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



<div class="BoardWrapper">
	<div class="BoardDiv">
	<p>자유 게시판</p>
		<table class="table table-striped table-hover">
			<thead>
			<tr>
				<td>번호</td>
				<td style="width: 150px;">제목</td>
				<td>작성자</td>
				<td style="width: 200px;">작성일</td>
				<td>조회</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="list">
			<fmt:formatDate var="reg" value="${list.reg}" pattern="yyyy-mm-dd hh:mm:ss "/>
			<tr>
				<td>${list.idx}</td>
				<td><a href="BoardDetail?idx=${list.idx}">${list.title}</a></td>
				<td>${list.writer}</td>
				<td>${reg}</td>
				<td>${list.hit}</td>
			</tr>
			</c:forEach>
		
			</tbody>
		</table>
		<button class="btn btn-primary" onclick="writeForm()">글쓰기</button>
	</div>
</div>

<jsp:include page="/WEB-INF/views/Footer.jsp"/>		
</body>
</html>