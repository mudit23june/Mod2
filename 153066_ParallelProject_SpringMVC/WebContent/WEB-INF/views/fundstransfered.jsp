<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Funds Transferred</title>
	</head>
	<body bgcolor=cyan>
		<a href=""> Log out </a>
		<h1> Funds successfully transfered </h1>
		<h2> Welcome ${customer.name} </h2>
		<h2> Your account number : ${customer.mobileNo} </h2>
		<h2> Your Balance : ${customer.wallet.balance} </h2>
	</body>
</html>