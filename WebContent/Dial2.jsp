<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function() {

	  $("#dialog").dialog({
	     autoOpen: true,
	     modal: true
	   });

	  $("#myButton").on("click", function(e) {
	      e.preventDefault();
	      $("#dialog").dialog("open");
	  });

	});
</script>
<body>
<button id="myButton">click!</button>

<div id="dialog" title="Dialog box">
  My content
</div>
</body>
</html>