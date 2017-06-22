<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add an Order</title>
</head>
<body>
    <h1> ADD Person PAGE</h1>
	<form action="/testAPI/persons" method="post">
	<table>
		<tr>
			
			<td><input type="hidden" name="id" value="${person.id}" /> </td>
		</tr>
		<tr>
			<td>First Name :</td>
			<td><input type="text" name="firstName" value="${person.firstName}" /> </td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastName" value="${person.lastName}" /> </td>
		</tr>
                <tr>
			<td>Email :</td>
			<td><input type="text" name="email" value="${person.email}" /> </td>
		</tr>
                 <tr>
			<td>Phone :</td>
			<td><input type="text" name="phone" value="${person.phone}" /> </td>
		</tr>
		
	</table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" value="Add Person"/>
	</form>
	
</body>
</html>