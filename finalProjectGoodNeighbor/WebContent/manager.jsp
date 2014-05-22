<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body dir="rtl">
<div data-role="page" id="manager">
		<div data-role="header">
			<label align ="center">ברוכים הבאים - אנא בחר אחת מהאופציות הבאות</label>
		</div>

		<div data-role="main" class="ui-content" align = "center">
			<p>
				<a data-role="button" data-inline="true" href="approveNewVolunteers">אישור מתנדבים חדשים</a>
			</p>
			<p>
				<a data-role="button" data-inline="true" href="allVolunteers">צפייה בכל המתנדבים</a>
			</p>
			<p>
				<a data-role="button" data-inline="true" href="allMaps">צפייה במפות</a>
			</p>
			<p>
				<a data-role="button" data-inline="true" href="allFamilies"> צפייה במשפחות </a>
			</p>
			<p>
				<a data-role="button" data-inline="true" href="addNewMaps">הוספת מפות חדשות</a>
			</p>
		</div>

		<div data-role="footer" data-position = "fixed">
			<p align="left">
				<a href="#mainPage">יציאה</a> 
				Good Neighbor&copy; 
			</p>
		</div>
	</div>
</body>
</html>