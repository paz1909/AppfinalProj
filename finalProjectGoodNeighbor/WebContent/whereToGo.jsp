<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<div data-role="page" data-close-btn="right" id="whereToGo">
		<div data-role="header" data-iconpos="right">
			<label align="center">��� ���</label>
		</div>
		<script>
				$("#isComing").on("click",function() {
							isComing();
					});
		</script>
		<div data-role="main" class="ui-content">
			<label>��� ������ �����?</label>
			<a id="isComing" data-role = "button" data-inline = "true">��� �����</a>
			<a href="#mainPage" data-role = "button" data-inline = "true">���� ����</a>
		</div>
		<div data-role="footer" data-position="fixed">
		<p align="left">
				Good Neighbor&copy; 
		</p>
		</div>
	</div>
</body>
</html>