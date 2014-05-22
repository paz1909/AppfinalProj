<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<%@ page import="il.good.neighbor.model.Family" %>
</head>
<body dir="rtl">
<% Family family = (Family) request.getAttribute("family"); %> 
<div data-role="page" data-close-btn="right" id="editFamily">
		<div data-role="header">
			<label align="center">עריכת משפחה</label>
		</div>
		<div data-role="main" class="ui-content">
			<label>עריכת משפחה</label>
			<form action ="editFamily">
			<%if(family != null){ %>
				<label for="firstName">שם פרטי</label> 
				<input type="text" name="firstName" value=<%=family.getFirstName() %>>
				
				<label for="lastName">שם משפחה</label> 
				<input type="text" name="lastName" value=<%=family.getLastName() %>> 
				
				<label for="phoneNumber">טלפון סלולרי</label> 
				<input type="tel" name="phoneNumber" value=<%=family.getPhoneNumber() %>> 
				
				<label for="city">עיר</label> 
				<input type="text" name="city" value=<%=family.getCity() %>>
				
				<label for="street">רחוב</label> 
				<input type="text" name="street" value=<%=family.getStreet() %>>
				
				<label for="houseNumber">מספר בית</label> 
				<input type="text" name="houseNumber" value=<%=family.getStreetNumber() %>>
				
				<label for="appartmentNumber">מספר דירה</label> 
				<input type="text" name="appartmentNumber" value=<%=family.getHouseNumber() %>>
				
				<label for="comments">הערות</label> 
				<input type="text" name="comments" value=<%=family.getComments() %>>
				
				
				<%} else {%>
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
				<input type="text" name="houseNumber">
				
				<label for="appartmentNumber">מספר דירה</label> 
				<input type="text" name="appartmentNumber">
				
				<label for="comments">הערות</label> 
				<input type="text" name="comments">
				<%} %>
				<input type="submit" data-inline="true" value="ערוך">
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