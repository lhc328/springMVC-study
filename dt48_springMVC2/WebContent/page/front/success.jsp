<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录成功</h1>
	<!-- 通过request域来保存数据 -->
	通过request域来保存数据:${requestScope.user}
	
	<!-- 通过model封装数据 -->
	 通过model封装数据:${requestScope.username }
	 
	 通过map封装数据:${requestScope.aaa}
</body>
</html>