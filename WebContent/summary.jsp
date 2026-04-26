<link rel="stylesheet" href="resources/bootstrap.css">
   <link rel="stylesheet" href="resources/mystyle.css">
   
     <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
   
<nav class="navbar navbar-expand-lg navbar-light mynav">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">
    Student
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="adminlogin.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="register.jsp">Register New Student</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Manage Student
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="ViewstdsCtrl">View Students</a></li>
            <li><a class="dropdown-item" href="summary.jsp">Summary Student</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="profile.jsp">View Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="UserLogout">Logout</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-warning" type="submit">Search</button>
      </form>
    </div>
  </div>
  <%
	response.setHeader("Cache-Control","no-cache, no-store" );
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0  );
	
	if(session.getAttribute("user") == null)
	{ %>
	<jsp:forward page="index.jsp"></jsp:forward>
<% 	}  %>
</nav>
<script type="text/javascript" src="resources/myscript.js"></script>
