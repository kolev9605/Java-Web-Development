<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Page</title>
</head>
<body>
	<h1>Bank</h1>	
	<form action="/03EnterpriseJavaBeans/Test" method="POST">
		<div>
			Client name/ID :
			<input type="text" name="client_id" style="width:100px">
		</div>
		<div>
			Current bank amount :
			<input type="number" name="current_amount" style="width:100px">
		</div>
		<div>
			<input type="radio" name="option" value="deposit" checked> Deposit
			<input type="radio" name="option" value="withdraw"> Withdraw
		</div>
		<div>
			Amount :
			<input type="number" name="amount" style="width:100px">
		</div>
		<input type="submit" value="Submit">
	</form>
</body>
</html>