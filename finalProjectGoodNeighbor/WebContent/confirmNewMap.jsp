<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body dir="rtl">
<div data-role="page" id="confirmNewMap" data-close-btn="none">
	<div data-role="header">
		</div>
		<div data-role="main" class="ui-content" align="center">
			<form method="get" action="addNewMaps">
				<label>המפה אושרה בהצלחה</label>
				<input type="submit" data-inline="true" value="אישור">
			</form>
		</div>

		<div data-role="footer" data-position = "fixed">
		<p align="left">
				Good Neighbor&copy; 
			</p>
		</div>
	</div>
</body>
</html>