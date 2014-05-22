<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<div data-role="page" id="volunteerMenu">
		<div data-role="header">
			<label align ="center">ברוכים הבאים - אנא בחר אחת מהאופציות הבאות</label>
		</div>
		<script>
				$("#isComing").on("click",function() {
							isComing();
					});
		</script>
		<div data-role="main" class="ui-content" align = "center">
			<p>
				<a data-role="button" data-rel = "dialog" data-inline="true" href="#rsvp">אישור הגעה</a>
			</p>
			<p>
				<a data-role="button" id="isComing" data-inline="true">דף מפות</a><!----לבדוק האם שמור ולפי זה לשלוח אותו לבחירת מפה או לפרטי מפה!--->
			</p>
		</div>

		<div data-role="footer" data-position = "fixed">
			<p align="left">
				<a href="#mainPage">יציאה</a> 
				Good Neighbor&copy; 
			</p>
		</div>
	</div>
</body>
</html>