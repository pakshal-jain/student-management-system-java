<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
</head>
<body>
 
<%@include file="header.jsp" %>  

<h1 class="pagename"> Home Page </h1>


<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="image/Slide_1.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>First slide label</h5>
        <p>Some representative placeholder content for the first slide.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="image/Slide_2.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Second slide label</h5>
        <p>Some representative placeholder content for the second slide.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="image/Slide_3.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Third slide label</h5>
        <p>Some representative placeholder content for the third slide.</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>




<%
	int no1 = 100;
	int no2 = 200;
	
	int sum = no1+ no2;
%>
<h2>
<%= no1 %>+
<%= no2 %> = 
<%= sum %>
</h2>
<%

		for(int i =0;i<=50; i+=5)
		{
	//		out.print("<h2>"+i+"<h2>");
			out.print(i);
}
%>
	  <div>
	  <h2> Calculate Interest </h2>
    <form action="MyFirstServlet" method="post">
        <input type="number" name="amount" placeholder="Enter Amount" required> <br><br>
        <input type="number" name="rate" placeholder="Enter Rate" required> <br><br>
        <input type="number" name="time" placeholder="Enter Time" required> <br><br>
        <input type="submit" value="Calculate">
    </form>
    <div>
    <h2>
    	<%=request.getAttribute("intrst")%>
     </h2>
    </div>
    </div>

<br><br><br><br>
<div class="bottombrg"></div>

<%@include file="footer.jsp" %>

</body>
</html>