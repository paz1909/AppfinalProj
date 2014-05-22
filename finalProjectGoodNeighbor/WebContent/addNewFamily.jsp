<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
</head>
<body dir="rtl">
<div data-role="page" id="addNewFamily" data-dialog="true" data-close-btn="right">
		<div data-role="header">
			<label align ="center">הוספת משפחה חדשה</label>
		</div>
		<!-- /header -->
		<div data-role="content">
			<form method="get">
			
				<label for="firstName">שם פרטי</label> 
				<input type="text" name="firstName"> 
				
				<label for="lastName">שם משפחה</label> 
				<input type="text" name="lastName">
				
				<label for="phoneNumber">טלפון סלולרי</label> 
				<input type="tel" name="phoneNumber">
				
				<label for="city">עיר</label> 
				<input type="text" name="city">
				
				<label for="street">רחוב</label> 
				<input type="text" name="street">
				
				<label for="houseNumber">מספר בית</label> 
				<input type="number" name="houseNumber" min="1">
				
				<label for="appartmentNumber">מספר דירה</label> 
				<input type="number" name="appartmentNumber" min="0">
				
				<label for="comments">הערות</label> 
				<input type="text" name="comments">
				
				<input type="submit" data-inline="true" value="הוסף משפחה">
			</form>
		</div>

		<!-- /content -->
		<div data-role="footer" data-position="fixed">
			<p align="left">
				Good Neighbor&copy;  
			</p>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>