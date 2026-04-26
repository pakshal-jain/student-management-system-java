<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
      <link rel="stylesheet" href="resources/mystyle.css">
 </head>
<body>

<%@include file="header.jsp" %>

<h1 class="pagename"> Login Page </h1>
<button onclick="welcome()">Welcome Click </button>

<% String res = (String) request.getAttribute("res");
if(res == null)
{
	res="-";
}
%>
    <div class="response">
    <%=res %>
    </div>
<div class="container">
<form class="p-4" action="Userlogin" method="post">

  <div class="mb-3">
<select class="form-select" aria-label="Default select example" name="user">
  <option selected>Open this select menu</option>
  <option value="student">STUDENT</option>
  <option value="admin">ADMIN</option>
</select>
  </div>

  <div class="mb-3">
    <label for="exampleDropdownFormEmail2" class="form-label">User ID</label>
    <input  class="form-control" id="exampleDropdownFormEmail2" type="number" name="uid" placeholder="Enter Your Email ID" required>
  </div>
  <div class="mb-3">
    <label for="exampleDropdownFormPassword2" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleDropdownFormPassword2" name="upassword" placeholder="Enter Your password" required>
  </div>
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</div>


<%@include file="footer.jsp" %>

<script src="resources/myscript.js"></script>

</body>
</html>