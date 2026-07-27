<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="insert_ok.do">
		이름:<input type="text" name="name" size=20><br>
		제목:<input type="text" name="subject" size=20><br>
		내용:<input type="text" name="content" size=20><br>
		비밀번호:<input type="text" name="pwd" size=20><br>
		<button type="submit">전송</button>
	</form>
</body>
</html>