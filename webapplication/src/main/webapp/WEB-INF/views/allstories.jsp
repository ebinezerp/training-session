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
		<table>
			<c:forEach items="${stories}" var="story">
				<tr>
					<td><a href="${contextPath}/customer/story/${story.id}">${story.title}</a></td>
					<td>${story.customer.fullname}</td>
				</tr>
			</c:forEach>
		</table>
	</section>
</body>
</html>