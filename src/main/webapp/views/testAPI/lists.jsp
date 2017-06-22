<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lists</title>
</head>
<body>
	<h1>Orders</h1>
	<table>
            <tr>
		<td>ID</td>
		<td>Order Date</td>
		<td>Person</td>
            </tr>
            <c:forEach var="order" items="${orders}">
            <tr>
                    <td>${order.id}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.person.firstName} &nbsp; ${order.person.lastName}</td>
                    
<!--                    <td><a href="orders/${order.id}">edit</a></td>-->
            </tr>
	</c:forEach>
	
	
	
	</table>
	 
	<a href="<c:url value="/testAPI/orders" />"> Add Order </a>
        
        <h1>Persons</h1>
	<table>
            <tr>
		<td>ID</td>
		<td>First Name</td>
		<td>Last Name</td>
                <td>Email</td>
                <td>Phone</td>
            </tr>
            <c:forEach var="person" items="${persons}">
            <tr>
                    <td>${person.id}</td>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td>${person.email}</td>
                    <td>${person.phone}</td>
                    <td><a href="/testAPI/persons/${person.id}">edit</a></td>
                   
            </tr>
	</c:forEach>
	
	
	
	</table>
	 
	<a href="<c:url value="/testAPI/persons" />"> Add Person </a>
        
        
        <h1>Products</h1>
	<table>
            <tr>
		<td>ID</td>
		<td>Product Name</td>
		<td>Product Description</td>
                <td>Price</td>
                <td>Product Type</td>
            </tr>
            <c:forEach var="product" items="${products}">
            <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.productType}</td>
                    <td><a href="/testAPI/products/${product.id}">edit</a></td>
                   
            </tr>
	</c:forEach>
	
	
	
	</table>
	 
	<a href="<c:url value="/testAPI/products" />"> Add Product </a>
</body>
</html>