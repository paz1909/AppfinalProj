<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
<%@ page import="java.util.List" %>
<%@ page import="il.good.neighbor.model.Volunteer" %>
</head>
<body dir="rtl">
<% List<Volunteer> volunteers = (List<Volunteer>) request.getAttribute("volunteers"); %>
<div data-role="page" id="allVolunteers">
		<div data-role="header">
			<label align ="center">רשימת המתנדבים:</label>
		</div>

		<div data-role="main" class="ui-content">
		
		<form class="ui-filterable">
     	 	<input id="myFilter" data-type="search" >
	    </form>
	    <ul data-role="collapsibleset" id ="allVolunteersColl"data-filter="true" data-input="#myFilter" data-autodividers="true" data-inset="true">
	     	<% for(Volunteer v : volunteers) {%>
		        <div data-role="collapsible" data-iconpos="right">
		        	<h3><%= v.getUserName()%> </h3>
		        	<table>
		        	<tr>
		        	<td>שם</td>
		        	<td><%= v.getFirstName() + " " + v.getLastName() %></td>
		        	</tr>
		        	<tr>
		        	<td>ת.ז</td>
		        	<td><%= v.getId() %></td>
		        	</tr>
		        	<tr>
		        	<td>טלפון</td>
		        	<td> <%= v.getPhoneNumber()%></td>
		        	</tr>
		        	<tr>
		        	<td>אימייל</td>
		        	<td><%= v.getEmail() %></td>
		        	</tr>
		        	</table>
		        		
		        </div>
		                  
		      <%} %>
	    </ul>
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