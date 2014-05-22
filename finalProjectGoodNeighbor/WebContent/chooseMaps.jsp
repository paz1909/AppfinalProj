<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="windows-1255"%>
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
	
	<% List<Map> maps = (List<Map>) request.getAttribute("maps"); %> 
	<%  %>
	<div data-role="page" id="chooseMaps">
		<div data-role="header">
			<label align = "center">ברוכים הבאים לשכן טוב</label>
		</div>
		<!-- /header -->
		<div data-role="content">
			<p><label>אנא בחר מפה</label></p>

		</div>
		<div data-role="main" class="ui-content" align="center" >
			<form method="get">
			<fieldset data-role="controlgroup" data-type="vertical"> 
					<div data-role="collapsible-set" id="chooseMapColl">
				
						<%for(Map m : maps) {%>
							<% for(Family f : m.getFamilies()) {%>	
						      
						      <input type="radio" name="mapRadio" value=<%= m.getMapId()%>>
						      <div data-role="collapsible" data-iconpos="right" >
						      <h3><%= m.getAreaName() %></h3>
						        <div data-role="collapsible-set" id="chooseMapColl">
						        	<div data-role="collapsible" data-iconpos="right">
						        	<h3> <%= f.getFirstName() + " " + f.getLastName() %></h3>
						        	<table> 
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
						        	
						        	</table>
						        		
						        	</div>
						        </div>
						      </div>
						      <%} %>
					 		<%} %>
					</div>
					

			</fieldset>
			<input type="submit" data-inline="true" value="בחר"> <br>
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