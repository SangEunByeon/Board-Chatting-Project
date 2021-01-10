<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">

<style>
	.DatailWrapper{
	display: flex;
	justify-content: center;
	text-align: center;
	}
	.DatailDiv{
	margin-top: 120px;
	width: 1000px;
	}
	p{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 30px;
	}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/Header.jsp"/>

<div class="DatailWrapper">
	<div class="DatailDiv">
	<p>글 보기</p>
		<table class="table">
			<tr>
				<td colspan="1" class="table-secondary">글 제목</td>
				<td colspan="3">글제목입니당.</td>
			</tr>
			<tr>
				<td colspan="1" class="table-secondary">글쓴이</td>
				<td colspan="1">글쓴이입니당.</td>
				<td colspan="1" class="table-secondary">조회수</td>
				<td colspan="1">0</td>
			</tr>
			<tr style="height: 200px">
				<td colspan="1" class="table-secondary">글 내용</td>
				<td colspan="3">글내용입니당.</td>
			</tr>
		</table>
		<button class="btn btn-primary">목록으로</button>
	
	
	</div>
	</div>
	

</body>
</html>