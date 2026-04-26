<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>About Us</title>
      <link rel="stylesheet" href="resources/mystyle.css">
</head>
<body>

<%@include file="header.jsp" %>

<h1 class="pagename"> About Us Page </h1>

<h2> Name: <%=request.getAttribute("nm") %> </h2>
<%
	String c = (String) request.getAttribute("cr");
	String m = (String) request.getAttribute("mo");
	String cty = (String) request.getAttribute("ct");
	String nd = "NO Details are Available";
	if(c==null || m==null || cty==null )
	{
		out.print("No Details Available");
		c = nd; m = nd;cty = nd;
	}
%>
<h2> Course: <%=c %> </h2>
<h2> Mobile: <%=m %></h2>
<h2> City: <%=cty %></h2>


<%@include file="footer.jsp" %>

</body>
</html>