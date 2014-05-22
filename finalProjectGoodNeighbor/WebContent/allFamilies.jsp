<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<%@ page import="java.util.List" %>
<%@ page import="il.good.neighbor.model.Map" %>
<%@ page import="il.good.neighbor.model.Family" %>
</head>
<body dir="rtl">
<% List<Family> families = (List<Family>) request.getAttribute("families"); %> 
<div data-role="page" id="allFamilies">
		<div data-role="header">
			<label align ="center">רשימת המשפחות</label>
		</div>

		<div data-role="main" class="ui-content">
		
	    
	    <form class="ui-filterable">
      		<input id="myFilter" data-type="search">
   		
	    <ul data-role="collapsibleset" id ="allFamiliesColl"data-filter="true" data-input="#myFilter" data-autodividers="true" data-inset="true">
	     			
	     			
							<% for(Family f : families) { %>	
						        	<li><div data-role="collapsible" data-iconpos="right">
						        		<h3> <%= f.getFirstName() + " " + f.getLastName() %></h3>
							        	<table> 
							        	<tr>
							        	<td><%= f.getMap().getAreaName() %></td>
							        	<td>משויך למפה</td>
							        	</tr>
							        	<tr>
							        	<td><%= f.getPhoneNumber() %></td>
							        	<td>טלפון</td>
							        	</tr>
							        	<tr>
							        	<td> <%=  f.getHouseNumber() + "/" + f.getStreetNumber() + " " + f.getStreet()+ " "+f.getCity()%></td>
							        	<td>כתובת</td>
							        	</tr>
							        	<tr>
							        	<td><%= f.getComments() %></td>
							        	<td>הערות</td>
							        	</tr>
							        	<tr>
							        	<%String hrefStr="editFamily?family="+f.getId(); %>
							        	<td><a data-role="button" data-inline="true" href=<%=hrefStr%>>ערוך משפחה</a>></td>
							        	<td>הערות</td>
							        	</tr>
							        	</table>
						        	</div></li>
						       
					 		<%} %>

	    </ul>
		
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