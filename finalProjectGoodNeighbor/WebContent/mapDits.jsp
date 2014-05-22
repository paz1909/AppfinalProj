<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
</head>
<body dir="rtl">
<div data-role="page" id="mapDits">
		<div data-role="header">
			<label align = "center">ברוכים הבאים לשכן טוב</label>
		</div>
		<!-- /header -->
		<div data-role="content">
			<p></p>

		</div>
		<div data-role="main" class="ui-content" align="right">
		<form>
				<div data-role="collapsible-set" id="mapDitsColl"> 
					</div>
					<script>
						$(document).on('pageinit', '#mapDits', function () 
						 {
							//var result = moveTojava.allMapsInit();
							var result = '{"map":{"mapName":"mapname","families":[{"firstName":"oren","lastName":"lasko"}]}}';
							var json = JSON.parse(result);	
							var collapsibleSet=$("#mapDitsColl");
							var familyLength = json.map.families.length;
							for(var j =0;j<familyLength;j++)
							{
								
								var firstName = json.map.families[j].firstName;
								var lastName = json.map.families[j].lastName;
								var phoneNumber = json.map.families[j].phoneNumber;
								var city = json.map.families[j].city;
								var street = json.map.families[j].street;
								var streetNumber = json.map.families[j].streetNumber;
								var houseNumber = json.map.families[j].houseNumber;
								var comments = json.map.families[j].comments;
								var collapsible= $('<div data-role="collapsible" data-iconpos="right" id="col'+j+'"></div>');
								collapsible.append('<h3>משפחה מספר '+(j+1)+'</h3>');
								collapsible.append('<h4>'+firstName+'</h4>');
								collapsible.append('<h4>'+lastName+'</h4>');
								collapsible.append('<h4>'+phoneNumber+'</h4>');
								collapsible.append('<h4>'+city+'</h4>');
								collapsible.append('<h4>'+street+'</h4>');
								collapsible.append('<h4>'+streetNumber+'</h4>');
								collapsible.append('<h4>'+houseNumber+'</h4>');
								collapsible.append('<h4>'+comments+'</h4>');
								collapsibleSet.append(collapsible);
							}
							collapsibleSet.trigger('create');
							$("#switchMap").on("click",function() {
								switchMap();
							});
							$("#endOfDelivery").on("click",function() {
								endOfDelivery();
							});
						 });
					 </script>
				<a data-role="button" data-inline="true" id="switchMap">החלף מפה</a>
				<a data-role="button" id = "endOfDelivery" data-rel="dialog" data-transition="slidedown" data-inline="true">סיימתי לחלק</a>
			</form>
		</div>
		<!-- /content -->
		<div data-role="footer" data-position="fixed">
			<p align="left">
				<a href="#mainPage">יציאה</a> 
				Good Neighbor&copy; 
			</p>
		</div>
		<!-- /footer -->
	</div>

</body>
</html>