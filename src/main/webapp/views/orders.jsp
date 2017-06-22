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
</head>
<div class="row1">
	<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Brand</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse navbar navbar-inverse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li ><a href="/">Products</a></li>
							<li class="active"><a href="/orders/view">Orders</a></li>
						</ul>
						
						<ul class="nav navbar-nav navbar-right">
                                                    
							<li><a href="/login">Login</a></li>
                                                    
							<li><a href="/registration">Register</a></li>
							<li><a href="/logout">Logout</a></li>
                                                        
						</ul>
					</div><!-- /.navbar-collapse -->
				</div><!-- /.container-fluid -->
			</nav>
</div>

    <div class="container">
        <c:forEach items="${orders}" var="order">
            <div class="page-header">
              <h3>${order.person.firstName}</h3>      
            </div>
                <c:forEach items="${order.orderLines}" var="orderLine">
                    <p>Product: ${orderLine.product.productName}</p>  
                    <p>Price: ${orderLine.product.price}</p>  
                    <p>Quantity: ${orderLine.quantity}</p> 
                    <p>total:${orderLine.getSubtotal()}</p> 

                </c:forEach>
            </div>
        </c:forEach>
<!--<div class="container">
    
    

	<div class="row">
		<c:forEach items="${orders}" var="order">
			<ul>${order.orderDate} => ${order.person.firstName}
				<c:forEach items="${order.orderLines}" var="orderLine">
					<li>Product Name: ${orderLine.product.productName} </li>
					<li>Quantity: ${orderLine.quantity} </li>
				</c:forEach>
			</ul>
		</c:forEach>
	</div>
</div>-->
</body>
</html>