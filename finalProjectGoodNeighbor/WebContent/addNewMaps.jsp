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
<% List<Family> families = (List<Family>) request.getAttribute("families"); %> 
<div data-role="page" id="addNewMaps">
		<div data-role="header">
			<label align ="center">פתיחת מפה חדשה</label>
		</div>
		<div data-role="main" class="ui-content" align = "center">
		<label>הכנסת מפות חדשות נעשית בשלבים - קודם כל מכניסים את המשפחות</label>
			<label>ולאחר מכן מצוותים את המשפחות למפות</label>
			<label>אנא הכנס את כל המשפחות ולאחר מכן לחץ על המשך</label>
		<form method="get">
			<fieldset>
				<p>
				<input type="checkbox" class="checkall" id="checkBtn">סמן הכל
				</p>
				<script>	
						$('#checkBtn').click(function() {			
							$(this).closest('fieldset').find(':checkbox').prop('checked', this.checked);
						});
						function clickCheck()
						{
							var checked;
                            checked = document.getElementById("checkBtn").checked;
                            if(checked == true)
                            {
                                $("input[type='checkbox']:first").attr("checked",false).checkboxradio("refresh");
                            }
						}
				</script>
					<div data-role="collapsible-set" id="newMapsColl"> 
							<% for(Family f : families) {%>   
						     <input type="checkbox"  onclick="clickCheck()" name="familyCheck" value=<%=f.getId()%>>
						      <div data-role="collapsible" data-iconpos="right" >
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
						      <%} %>
					</div>
					</fieldset>
					
			
			<p>
				<a href="#addNewFamily" data-rel="dialog" data-transition="slidedown" data-role="button" data-inline="true">הוסף משפחה</a><br>
				<input type="submit" data-inline="true" value="צוות למפות">
			</p>
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