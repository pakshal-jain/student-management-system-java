<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
      <link rel="stylesheet" href="resources/mystyle.css">
</head>

<body>
<%@include file="headeradmin.jsp" %>

<%
//	String u = (String) request.getAttribute("user");
	String u = (String) session.getAttribute("user");
if(u == null )
{
	u = "User Name NA";
} 

%>
<h1>Welcome: <%=u %> </h1>

<h2> Admin Controls</h2>

<%@include file="footer.jsp" %>
</body>
</html>