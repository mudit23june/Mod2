<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome</title>
	</head>
	<body bgcolor=cyan>
		<a href=""><font color=blue>Log out</font></a><br>
		<a href=""><font color=blue>View Wallet</font></a>
		<div align="center">
			<h2><font color=blue>Welcome ${customer.name}</font></h2>
			<h2><font color=green>Your Balance</font> : ${customer.wallet.balance}</h2>
		</div>
	</body>
</html>