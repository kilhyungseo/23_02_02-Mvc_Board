<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정</title>
</head>
<body>
	<h2>게시판 글 수정</h2>
	<hr>
		
		<table border="1" cellspacing="0" cellpadding="0" width="600">
		<form action="modify.do">
		<input type="hidden" name="bid" value="${dto.bid }">
		<tr>
			<td colspan="6"><input type="text" name="btitle" value="${dto.btitle }" size="80"></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${dto.bdate }</td>
			<td>글쓴이</td>
			<td>${dto.bname }</td>
			<td>조회수</td>
			<td>${dto.bhit }</td>
		</tr>
		<tr>
			<td colspan="6" height="100"><textarea name="bcontent" rows="10" cols="50" >${dto.bcontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="6" align="right">
			<input type="submit" value="수정완료">
			<input type="button" value="취소" onclick="javascript:window.location='list.do'">
			
			</td>
		</tr>
		</form>
		</table>
		
</body>
</html>