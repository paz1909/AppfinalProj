<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<div data-role="page"  id="unRegisteredUser" data-close-btn="right" >
		<div data-role="header">
			<label align = "center">������ ����� ���� ���</label>
		</div>
		<!-- /header -->
		<div data-role="content" align = "center">
			<p><label>:����� ������� �����</label></p>
			
			<form name="signup" onsubmit="return signUp()" data-ajax = "false">
				<label for="firstname">�� ����</label> 
				<input type="text" name="firstname" id="firstname" required="required"> 
				<label for="lastname">�� �����</label> 
					<input type="text" name="lastname" id="lastname" required="required"> 
					<label for="username">�� �����</label> 
					<input type="text" name="username" id="username" required="required"> 
					<label for="password">�����</label> 
					<input type="password" name="password" id="password" required="required"> 
					<label for="id">�.�</label> 
					<input type="text" name="id" id="id" required="required">
				<label for="phonenumber">����� ������</label> 
				<input type="tel" name="phonenumber" id="phonenumber" required="required"> 
				<label for="email">email:</label>
				<input type="email" name="email" id="email" required="required"> 
					<input type="submit" data-inline="true" value="�����">
			</form>
			
		</div>

		<!-- /content -->
		<div data-role="footer" data-position="fixed">
		<p align= "left">
		<label>
			Good Neighbor&copy;
		</label>
			</p>
		</div>
	</div>

	
</body>
</html>