<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<div data-role="page" data-close-btn="right" id="rsvp">
		<div data-role="header" data-iconpos="right">
			<label align="center">שכן טוב</label>
		</div>
		<script>
				$("#coming").on("click",function() {
							coming();
					});
		</script>
		<div data-role="main" class="ui-content">
			<label>האם אתה מגיע היום לחלוקה?</label>
			<a href="#whereToGo" id="coming" data-rel = "dialog" data-role = "button" data-inline = "true">כן</a>
			<a href="#notComing" data-rel = "dialog" data-role = "button" data-inline = "true">לא</a>
		</div>
		<div data-role="footer" data-position="fixed">
		<p align="left">
				Good Neighbor&copy; 
		</p>
		</div>
	</div>
</body>
</html>