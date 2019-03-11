<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Fund Transfer</title>
	</head>
	<body bgcolor=cyan>
		<a href=""><font color=blue>Home</font></a>
		<br><br>
		<form action="fundtransfered" method="get">
			<tr>
				<td>Enter Source <img src = C:\Users\MUAGRAWA\Desktop\mobile.png height=20 width=20> </td>
				<td><input type="number" name="sourceMobileNo" size="30" /></td>
			</tr>
			<br><br>
			<tr>
				<td>Enter Destination <img src = C:\Users\MUAGRAWA\Desktop\mobile.png height=20 width=20> </td>
				<td><input type="number" name="destinationMobileNo" size="30" /></td>
			</tr>
			<br><br>
			<tr>
				<td>Enter Amount <img src = C:\Users\MUAGRAWA\Desktop\money.jpg height=20 width=20> </td>
				<td><input type="number" name="balance" size="30" /></td>
			</tr>
			<br><br>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</form>
	</body>
</html>