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
<div data-role="page" id="approveNewVolunteers">
		<div data-role="header">
			<label align ="center">רשימת המתנדבים:</label>
		</div>

		<div data-role="main" class="ui-content" align="center">
		
			<form>
			<fieldset> 
				<p>
				<label for="checkBtn">סמן הכל</label>
				<input type="checkbox" class="checkall" name="checkBtn" id="checkBtn">
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
				</p>
					<div data-role="collapsible-set" id="approveNewVolunteersColl"> 
					<% for(Volunteer v : volunteers) {%>
					<input type="checkbox" onclick="clickCheck()" name="checkVols" value=<%=v.getId() %>>
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
					
					</div>
					</fieldset>
					<input type="submit" data-inline="true" value="אשר את כל המסומנים"> <br>
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