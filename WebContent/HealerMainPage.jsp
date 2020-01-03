<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>SelfHealer</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
  
html,
body {
  height: 100%;
	/* background: #d8cb61; */
	background: rgb(169,219,128); /* Old browsers */
background: -moz-linear-gradient(top, rgba(169,219,128,1) 0%, rgba(150,197,111,1) 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, rgba(169,219,128,1) 0%,rgba(150,197,111,1) 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, rgba(169,219,128,1) 0%,rgba(150,197,111,1) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#a9db80', endColorstr='#96c56f',GradientType=0 );
}

.navbar-default {
    background: none;
  	border: none;
}

.logo img{
	float:left;
	width: 70px;
	height: 1.5cm;
}
.navbar-inverse{
background: #000007;
}
</style>
<script>
	function Signout() {
		document.HealerMainPageForm.method = "post";
		document.HealerMainPageForm.action = "./Signout";
		document.HealerMainPageForm.submit();
	}
</script>
</head>
<body>
<%
	
	String UN = (String) session.getAttribute("UserName");
			String DispName = (String) session.getAttribute("DisplayName");
	%>
	<form name = "HealerMainPageForm">
<nav class="navbar navbar-inverse">
<div class="logo">
		<img src = "./winlogo1.jpg">
	</div>
<h1 style ="color:#ffffff; text-align: center; text-indent: -3%;">MSS Self Help Tool</h1>
<ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Welcome <%=DispName %></a></li>
      <li><a href="#" onclick="Signout();"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>

  <div class="container-fluid">
    <!-- <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div> -->
    <ul class="nav navbar-nav">
      <li class="active"><a href="HomePage.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="HealerDDFix.jsp">Due Date Completion</a></li>
          <!-- <li><a href="HealerDDFix.jsp">Due Date Completion(Starnet)</a></li> -->
          <li><a href="HealerCktRemoval.jsp">ISR Circuit Removal</a></li>
          <li><a href="CircuitServiceTypeCode.jsp">Circuit Service Type Code</a></li>
          <!-- <li><a href="HealerCktRemoval.jsp">LIDB/CNAM Extract Removal</a></li> -->
        </ul>
      </li>
     </ul>
    
  </div>
</nav>
</form>
</body>
</html>
