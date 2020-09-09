<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="customer_header.jsp"%>
	<section>
		<sf:form action="${contextPath}/customer/update" method="POST" modelAttribute="customer">
			<table>
				<tr>
					<td><sf:input type="hidden" path="id" /></td>
				</tr>
				<tr>
					<td><label>Full Name</label></td>
					<td><sf:input path="fullname" /></td>
					<td><sf:errors path="fullname"/> </td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><sf:input path="email" /></td>
					<td><sf:errors path="email"/> </td>
				</tr>
				<tr>
					<td><label>Mobile</label></td>
					<td><sf:input path="mobile" /></td>
					<td><sf:errors path="mobile"/> </td>
				</tr>
				<tr>
					<sf:input type="hidden" path="password" />
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="update" /></td>
				</tr>
			</table>
		</sf:form>
	</section>
</body>
</html>