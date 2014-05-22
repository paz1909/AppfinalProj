<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body dir="rtl">
<div data-role="page" id="addNewMap">
		<div data-role="header">
			<label align ="center">ציוות משפחות למפות</label>
		</div>
		
		<div data-role="main" class="ui-content" align = "center">
		<script>
				$("#addNewMap").on("click",function() {
							test();
					});
		</script>
			<form method="get" action="addNewMap">
				<label for="areaName">שם האיזור</label> 
				<input type="text" name="areaName">
				<input type="submit" data-inline="true" value="אישור">
			</form>
		</div>

		<div data-role="footer" data-position = "fixed">
			<p align="left">
			<a href="#manager">חזרה לדף מנהלים</a>
				<a href="#mainPage">יציאה</a> 
				Good Neighbor&copy; 
			</p>
		</div>
	</div>
	
</body>
</html>