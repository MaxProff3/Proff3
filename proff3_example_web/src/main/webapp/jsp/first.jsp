<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.block{
		background: red;
		margin-top:10px;
	}
</style>
</head>
<body>
	first page
	<% List<String> list = (List<String>)request.getAttribute("list"); %>
	<% if(1>0) for(String s: list)out.println(s+"<br>"); %>
	<hr>
	<% for(String s: list){ %>
		<div class="block">
			<% out.println(s); %>
		</div>
	<%} %>
</body>
</html>