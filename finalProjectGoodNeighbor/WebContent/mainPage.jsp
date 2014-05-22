<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body dir="rtl">
	<div data-role="page" id="mainPage">
		<div data-role="header">
			<label align = "center">ברוכים הבאים לשכן טוב</label>
		</div>
		<div data-role="content" align = "center">
			<p>כניסת משתמשים:</p>
			<form accept-charset="UTF-8" method="post">
			<label>שם משתמש</label>
			<input type="text" name="userName"><br> 
			<label>סיסמא</label>
			<input type="password" name="password"> 
			<input type="submit" data-inline="true" value="היכנס"> <br> 
			<a href="unRegisteredUser" data-rel="dialog" data-transition="slidedown" data-role="button" data-inline="true">מתנדב חדש</a>
			</form>
			<img src="../logoGoodNeighbor.png" align="middle">
		</div>
		<div data-role="footer" data-position="fixed">
			<p align="left">
				Good Neighbor&copy;
				<a href="unApproved" data-rel="dialog" data-transition="slidedown">unApproved</a> 
				<a href="manager">manager</a>
				<a href="chooseMaps">maps</a>
			</p>
		</div>
	</div>
</body>
</html>