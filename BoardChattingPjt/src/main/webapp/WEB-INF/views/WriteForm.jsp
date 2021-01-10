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
	margin-bottom: 200px;
	}
	.WriteDiv{
	margin-top: 120px;
	width: 1000px;
	}
	textArea{
	width : 600px;
	height : 250px;
	resize: none;
	}
	p{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 30px;
	}
	</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/Header.jsp"/>

<div class="WriteWrapper">
	<div class="WriteDiv">
	<p>글 작성</p>
	<form action="WriteAction" method="post" enctype="multipart/form-data">
		<table class="table table-striped">
			<tr>
				<td colspan="1">글 제목</td>
				<td colspan="3"><input type="text" name="title" style="width : 600px"/></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>
					<select name="category">
						<option value="1">분류1</option>
						<option value="2">분류2</option>
						<option value="3">분류3</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><textarea type="textArea" name="contents" cols="70" row="100"></textarea></td>
			</tr>
			<tr>
				<td>이미지 첨부</td>
				<td><input type="file" multiple="multiple" name="files"/></td>
			</tr>
			<input type="hidden" name="writer" value="${id}"/>
		</table>
		<button type="submit" class="btn btn-primary">등록</button>
		<button type="button" class="btn btn-outline-primary">취소</button>
		</form>
	</div>
</div>

</body>
</html>