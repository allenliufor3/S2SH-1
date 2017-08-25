<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<base href="<%=basePath%>">
	<title>S2SH</title>
	
	</head>
	<body>
		<h1>Hello, welcome to use the S2SH.</h1>
		<a href="register.jsp">注册</a>
		<br/>
		<a href="user_single.jsp">查询用户</a>
		<br/>
		<a href="user_list.jsp">查询所有用户</a>
		<br/>
	</body>
</html>