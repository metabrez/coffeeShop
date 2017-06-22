<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add an Order</title>
</head>
<body>
    <h1> ADD ORDER PAGE</h1>
	<form action="/testAPI/orders" method="post">
	<table>
		<tr>
			
			<td><input type="hidden" name="id" value="${order.id}" /> </td>
		</tr>
		<tr>
			<td>Order Date</td>
			<td><input type="text" name="orderDate" value="${order.orderDate}" /> </td>
		</tr>
		<tr>
			<td>person</td>
			<td><input type="text" name="person" value="${order.setPerson(person)}" /> </td>
		</tr>
		
	</table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" value="Add Order"/>
	</form>
	
</body>
</html>