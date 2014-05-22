<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
<%@ page import="java.util.List" %>
<%@ page import="il.good.neighbor.model.Map" %>
<%@ page import="il.good.neighbor.model.Family" %>
</head>
<body dir="rtl">
<% List<Map> maps = (List<Map>) request.getAttribute("maps"); %>
<div data-role="page" id="allMaps">
		<div data-role="header">
			<label align ="center">רשימת המפות:</label>
		</div>

		<div data-role="main" class="ui-content">
		<form class="ui-filterable">
     	 	<input id="myFilter" data-type="search" >
	    </form>
		<fieldset>
	    <ul data-role="collapsibleset" id ="allMapsColl" data-filter="true" data-input="#myFilter" data-autodividers="true" data-inset="true">
	     	<%for(Map m : maps) {%>
	     	<li>
				<div data-role="collapsible-set" id="chooseMapColl">
						<% for(Family f : m.getFamilies()) {%>	
					      
					      <div data-role="collapsible" data-iconpos="right" >
					      	<h3><%= m.getAreaName() %></h3>
					        <div data-role="collapsible-set">
					        	<div data-role="collapsible" data-iconpos="right">
					        	<h3> <%= f.getFirstName() + " " + f.getLastName() %></h3>
					        	<table> 
					        	<% if(m.getIsChosenToday()){%>
					        	<tr>
					        	<td>המתנדב שמחלק מפה זו הוא </td>
					        	<td><%= m.getTemporaryVolunteer().getFirstName()+" "+m.getTemporaryVolunteer().getLastName() %></td>
					        	</tr>
					        	<% }%>
					        	<tr>
					        	<td>טלפון</td>
					        	<td><%= f.getPhoneNumber() %></td>
					        	</tr>
					        	<tr>
					        	<td>כתובת</td>
					        	<td> <%=  f.getHouseNumber() + "/" + f.getStreetNumber() + " " + f.getStreet()+ " "+f.getCity()%></td>
					        	</tr>
					        	<tr>
					        	<td>הערות</td>
					        	<td><%= f.getComments() %></td>
					        	</tr>
					        	</table>
					        		
					        	</div>
					        </div>
					        <a data-role="button" data-inline="true" href="#confirmReleaseMap" name="'+mapName+'" id="releaseMap">שחרר מפה ממתנדב</a>
							<a data-role="button" data-inline="true" href="#confirmDelMap" name="'+mapName+'" id="delMap">מחק מפה</a>
                        
					      </div>
					                  
					      <%} %>
					 <%} %>
					 
				</div>
			</li>						 
	    </ul>
		</fieldset>
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