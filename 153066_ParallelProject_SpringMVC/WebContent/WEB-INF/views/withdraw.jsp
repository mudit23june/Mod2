<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Withdraw Amount</title>
	</head>
	<body bgcolor=cyan>
		<h1><font color=blue><center>Withdraw Amount</center></font></h1>
		<a href=""><font color=blue>Home</font></a><br><br>
		<form action="withdrawmoney" method="get">
			<tr>
				<td><img src = C:\Users\MUAGRAWA\Desktop\mobile.png height=20 width=20></td>
				<td><input type="number" name="mobileNo" size="30" /></td>
			</tr>
			<br><br>
			<tr>
				<td><img src = C:\Users\MUAGRAWA\Desktop\money.jpg height=20 width=20></td>
				<td><input type="number" name="balance" size="30" /></td>
			</tr>
			<br><br>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</form>
	</body>
</html>