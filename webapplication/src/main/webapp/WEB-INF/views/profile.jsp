<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="customer_header.jsp"%>
	<section>
		<table>
			<tr>
				<td><label>Full Name</label></td>
				<td>${customer.fullname}</td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td>${customer.email}</td>
			</tr>
			<tr>
				<td><label>Mobile</label></td>
				<td>${customer.mobile}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a
					href="${contextPath}/customer/editprofile"><button>Edit</button></a></td>
			</tr>
		</table>

	</section>
</body>
</html>