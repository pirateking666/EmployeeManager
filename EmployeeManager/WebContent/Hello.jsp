<%@page import="java.sql.ResultSet"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Title</title>
</head>
<body>
	<%ResultSet res = (ResultSet)request.getAttribute("listAccount"); %>
	<%while(res.next()) {%>
	<h4><%=res.getString(1) %></h4>
	<%} %>
</body>
</html>