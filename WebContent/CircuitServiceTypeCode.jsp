<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>SelfHealer</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script>
	function doSummary() {
		if ("document.CktSvcTypeCodeForm.ord.focus()") {
			document.getElementById('ReturnMsgDiv').style.display = 'none';
		}
		if ("document.CktSvcTypeCodeForm.ckt.focus()") {
			document.getElementById('ReturnMsgDiv').style.display = 'none';
		}
	}
</script>
<style>
html, body {
	height: 100%;
	/* background: #d8cb61; */
	background: rgb(169, 219, 128); /* Old browsers */
	background: -moz-linear-gradient(top, rgba(169, 219, 128, 1) 0%,
		rgba(150, 197, 111, 1) 100%); /* FF3.6-15 */
	background: -webkit-linear-gradient(top, rgba(169, 219, 128, 1) 0%,
		rgba(150, 197, 111, 1) 100%); /* Chrome10-25,Safari5.1-6 */
	background: linear-gradient(to bottom, rgba(169, 219, 128, 1) 0%,
		rgba(150, 197, 111, 1) 100%);
	/* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#a9db80',
		endColorstr='#96c56f', GradientType=0);
}

.navbar-default {
	background: none;
	border: none;
}

.logo img {
	float: left;
	width: 70px;
	height: 1.5cm;
}

.navbar-inverse {
	background: #000007;
}





.clicky {
  /** Offset the Position **/
  position: relative;
  top: 0;
  margin-top: 0;
  margin-bottom: 10px;

  /** 3D Block Effect **/
  box-shadow: 0 10px 0 0 #ffffff;

  /** Make it look pretty **/
  display: block;
  background: #000000;
  color: #ffffff;
  padding: 1em 2em;
  border: 0;
  cursor: pointer;
  font-size: 1.2em;
  opacity: 0.9;
  border-radius: 10px;
}

.clicky:active {
  /** Remove 3D Block Effect on Click **/
  box-shadow: none;
  top: 10px;
  margin-bottom: 0;
}

.clicky:hover {
  opacity: 1;
}

.clicky:active,
.clicky:focus {
  /** Remove Chrome's Ugly Yellow Outline **/
  outline: 0;
}
</style>
<script>
	function Signout() {
		document.CktSvcTypeCodeForm.method = "post";
		document.CktSvcTypeCodeForm.action = "./Signout";
		document.CktSvcTypeCodeForm.submit();
	}
</script>
</head>
<body>
	<%
		String UN = (String) session.getAttribute("UserName");
		String DispName = (String) session.getAttribute("DisplayName");
	%>
	<form class="form-horizontal" action="CircuitServiceTypeCodeServlet"
		method="post" name="CktSvcTypeCodeForm">
		<nav class="navbar navbar-inverse">
			<div class="logo">
				<img src="./winlogo1.jpg">
			</div>
			<h1 style="color: #ffffff; text-align: center; text-indent: -3%">MSS
				Self Help Tool</h1>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Welcome <%=DispName%></a></li>
				<li><a href="#" onclick="Signout();"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>

			<div class="container-fluid">
				<!-- <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div> -->
				<ul class="nav navbar-nav">
					<li class="active"><a href="HomePage.jsp">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Menu<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="HealerDDFix.jsp">Due Date Completion</a></li>
							<!-- <li><a href="HealerDDFix.jsp">Due Date
									Completion(Starnet)</a></li> -->
							<li><a href="HealerCktRemoval.jsp">ISR Circuit Removal</a></li>
							<li><a href="CircuitServiceTypeCode.jsp">Circuit Service Type
									Code</a></li>
							<!-- <li><a href="HealerCktRemoval.jsp">LIDB/CNAM Extract
									Removal</a></li> -->
						</ul></li>
				</ul>

			</div>
		</nav>
		<br>
		<br>
		<center>
			<h2 style="font-family: Arial; font-size: 28px; font-weight: bold;">Circuit Service Type Code</h2>
		</center>
		<br>
		<br>
		<div class="col-md-4 col-md-offset-4">

			<div class="form-group">
				<label class="control-label col-sm-5" for="order">PSR Number</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" name="orderid" id="ord"
						placeholder="Enter Order Number" onclick="doSummary();">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="circuit">Circuit
					/ Ecckt</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" name="circuitid" id="ckt"
						placeholder="Enter Circuit / Ecckt" onclick="doSummary();">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="SvcTypeCode">Service
					Type Code</label>
				<div class="col-sm-7">
					<!-- <input type="text" class="form-control" id="environment" placeholder="Enter Environment"> -->
					<select class="form-control" id="svcTypeCode">
						<option>[Select]</option>
						<option>0 GB</option>
						<option>0GB</option>
						<option>5GB</option>
						<option>BD</option>
						<option>BJ</option>
						<option>BM</option>
						<option>CU</option>
						<option>DO</option>
						<option>EZ</option>
						<option>FE</option>
						<option>GE</option>
						<option>GE-NNI</option>
						<option>HC</option>
						<option>HF</option>
						<option>JI</option>
						<option>KD</option>
						<option>KE</option>
						<option>KF</option>
						<option>KG</option>
						<option>KJ</option>
						<option>KP</option>
						<option>KQ</option>
						<option>KR</option>
						<option>KX</option>
						<option>L1</option>
						<option>L2</option>
						<option>L3</option>
						<option>LO</option>
						<option>LU</option>
						<option>LV</option>
						<option>LX</option>
						<option>MH</option>
						<option>MJ</option>
						<option>OB</option>
						<option>OD</option>
						<option>OH</option>
						<option>OX</option>
						<option>OY</option>
						<option>OZ</option>
						<option>SZ</option>
						<option>T1</option>
						<option>T3</option>


					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="environment">Environment</label>
				<div class="col-sm-7">
					<!-- <input type="text" class="form-control" id="environment" placeholder="Enter Environment"> -->
					<select class="form-control" id="environment">
						<option>[Select]</option>
						<option>Devprod NGMSS</option>
						<option>Devprod Hwin</option>
						<option>Devprod Hpae</option>
						<option>Sysprod Elink</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-10">
					<button type="submit" class="btn btn">Submit</button>
				</div>
			</div>
			<br>
			<div id="ReturnMsgDiv">
				<%String msg = (String) request.getAttribute("ReturnMsg");
    		System.out.println("msg - "+msg);
    		if (msg!=null){
    		%>
  <h3  class = "clicky" style="font-family: Arial; font-size: 16px; font-style: italic; ">${ReturnMsg}</h3>
  <%} %>
			</div>

		</div>
	</form>
</body>
</html>
