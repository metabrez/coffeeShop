<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You are in!</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<form autocomplete="off" action="#"
				   method="post" class="form-horizontal"
				  role="form">
				<h2>profile Form</h2>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" name="firstName" placeholder="Name" class="form-control" value="${user.person.setFirstName(firstName)}" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" name="lastName" placeholder="Last Name" class="form-control" value="${user.person.setLastName(lastName)}" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" name="email" placeholder="Email" class="form-control" value="${user.person.setEmail(email)}" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" name="address" placeholder="Address" class="form-control" value="${user.person.setAddress(address)}" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" name="phone" placeholder="Phone" class="form-control" value="${user.person.setPhone(phone)}" />
					</div>
				</div>
				

				<div class="form-group">
					<div class="col-sm-9">
						<button type="submit" class="btn btn-primary btn-block">Update User</button>
					</div>
				</div>
				<h3>${successMessage}</h3>
			</form>
		</div>
	</div>
</div>


</body>
</html>