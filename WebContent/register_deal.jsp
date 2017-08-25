<%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="com.ming.s2sh.registration.service.*" %>
<%@ page import="com.ming.s2sh.registration.model.*" %>
<%@ page import="com.ming.s2sh.registration.service.impl.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String password2 = request.getParameter("password2");

	User u = new User();
	u.setUsername(username);
	u.setPassword(password);
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/s2sh", "root", "admin");
	
	UserManager um = new UserManagerImpl();
	boolean exist = um.exists(u);
	if(exist) {
		response.sendRedirect("registerFail.jsp");
		return;
	}
	
	um.add(u);
	response.sendRedirect("registerSuccess.jsp");
%>

