<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
		<TITLE>Popup div with disabled background</TITLE>
		<style>
			.ontop {
				z-index: 999;
				width: 100%;
				height: 100%;
				top: 0;
				left: 0;
				display: none;
				position: absolute;				
				background-color: #cccccc;
				color: #aaaaaa;
				opacity: .4;
				filter: alpha(opacity = 50);
			}
			#popup {
				width: 300px;
				height: 200px;
				position: absolute;
				color: #000000;
				background-color: #ffffff;
				/* To align popup window at the center of screen*/
				top: 50%;
				left: 50%;
				margin-top: -100px;
				margin-left: -150px;
			}
			.clicky {
  /** Offset the Position **/
  position: relative;
  top: 0;
  margin-top: 0;
  margin-bottom: 10px;

  /** 3D Block Effect **/
  box-shadow: 0 10px 0 0 #6B2A4A;

  /** Make it look pretty **/
  display: block;
  background: #a47;
  color: #eee;
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
		<script type="text/javascript">
			function pop(div) {
				document.getElementById(div).style.display = 'block';
			}
			function hide(div) {
				document.getElementById(div).style.display = 'none';
			}
			//To detect escape button
			document.onkeydown = function(evt) {
				evt = evt || window.event;
				if (evt.keyCode == 27) {
					hide('popDiv');
				}
			};
		</script>
	</HEAD>
	<BODY>
	<form name ="form" action = "servlet" method = "post">
	<div>
	<label class = "clicky" style = "text-align: center">Invoke Servlet Invoke Servlet Invoke Servlet Invoke Servlet</label>
	</div>
	<%String msg = null;
	msg = (String)request.getAttribute("Msg");
	System.out.println("Jsp Msg = "+msg);
	if(msg!=null){
	%>
	<div>
	<button class = "css3button">${Msg}</button>
	</div>
		<div id="popDiv" class="ontop">
			<table border="1" id="popup">
				<tr>
					<td>
						This can be used as a popup window
					</td>
				</tr>
				<tr>
					<td>
						<a href="#" onClick="hide('popDiv')">Close</a>
					</td>
				</tr>
			</table>
		</div>
		<CENTER>
			<h3>
				Simple popup div with disabled background
			</h3>
			<br/>
			<a href="#" onClick="pop('popDiv')">Click here to open a popup div</a>
		</CENTER>
		<%} %>
		</form>
	</BODY>
</HTML>