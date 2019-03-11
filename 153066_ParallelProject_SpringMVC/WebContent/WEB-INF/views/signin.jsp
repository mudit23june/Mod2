<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Create account here</title>
		<style>
			.error
			{
				color:red;
				font-weight:bold;
			}
		</style>
	</head>
	<body bgcolor=cyan>
		<h1> <center><font color=blue>Welcome to PaymentWallet</font></center> </h1>
		<a href="" > <font color=blue>Home</font> </a>
		<div align="center">
			<h2> Please Sign Up Here </h2>
		</div> 
		<table>
			<form:form action="registerCustomer" method="post" modelAttribute="customer">
			<tr>
				<td> <img src = C:\Users\MUAGRAWA\Desktop\user.png height=20 width=20> </td>
				<td>
					<form:input path="name" size="30"/>
				</td>
				<td>
					<form:errors path="name" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td> <img src = C:\Users\MUAGRAWA\Desktop\mobile.png height=20 width=20> </td>
				<td>
					<form:input path="mobileNo" size="30"/>
				</td>
				<td>
					<form:errors path="mobileNo" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td> <img src = C:\Users\MUAGRAWA\Desktop\money.jpg height=20 width=20> </td>
				<td>
					<form:input path="wallet.balance" size="30"/>
				</td>
				<td>
					<form:errors path="wallet.balance" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td> <input type="submit" value="Submit"/> </td>
			</tr>
		    </form:form>
		</table>
	</body>
</html>