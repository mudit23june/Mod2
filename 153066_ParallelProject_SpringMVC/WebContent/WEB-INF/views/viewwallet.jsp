<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Wallet</title>
	</head>
	<body bgcolor=cyan>
		<a href=""><font color=blue>Log out</font></a>
		<h2><center><font color=blue>Welcome ${customer.name}</font></center></h2><br><br>
		<h2><font color=green>Your Account Number</font> : ${customer.mobileNo}</h2>
		<h2><font color=green>Your Balance</font> : ${customer.wallet.balance}</h2>
		<h5>
			<a href="deposit"><font color=blue>Deposit</font></a>
		</h5>
		<h5>
			<a href="withdraw"><font color=blue>WithDraw</font></a>
		</h5>
		<h5>
			<a href="fundtransfer"><font color=blue>Fund Transfer</font></a>
		</h5>
	</body>
</html>