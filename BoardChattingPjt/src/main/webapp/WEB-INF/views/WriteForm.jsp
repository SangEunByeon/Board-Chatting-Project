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
	.WriteWrapper{
	display: flex;
	justify-content: center;
	text-align: center;
	}
	.WriteDiv{
	margin-top: 120px;
	width: 1000px;
	}
	</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/Header.jsp"/>

<div class="WriteWrapper">
	<div class="WriteDiv">
	<form action="WriteAction" method="post" enctype="multipart/form-data">
		<table class="table table-striped">
			<tr>
				<td>글 제목</td>
				<td><input type="text"/></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>
					<select name="">
						<option>분류1</option>
						<option>분류2</option>
						<option>분류3</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><input type="textArea"/></td>
			</tr>
			<tr>
				<td>이미지 첨부</td>
				<td><input type="file" multiple="multiple" name="files"/></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-primary">등록</button>
		<button type="button" class="btn btn-outline-primary">취소</button>
		</form>
	</div>
</div>

<jsp:include page="/WEB-INF/views/Footer.jsp"/>
</body>
</html>