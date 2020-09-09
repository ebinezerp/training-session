<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="customer_header.jsp"%>
	<section>

		<h1>${story.title}</h1>
		<p>${story.content}</p>
		<h4>${story.customer.fullname}</h4>

	</section>
</body>
</html>