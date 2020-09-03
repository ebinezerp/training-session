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
	<p>${errorMsg}</p>
	<sf:form action="register" method="POST"
		modelAttribute="customer">
		<table>
			<tr>
				<td><sf:input type="hidden" path="id" /></td>
			</tr>
			<tr>
				<td><label>Fullname</label></td>
				<td><sf:input path="fullname" /></td>
				<td><sf:errors path="fullname" /></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><sf:input path="email" /></td>
				<td><sf:errors path="email" /></td>
			</tr>
			<tr>
				<td><label>Mobile</label></td>
				<td><sf:input path="mobile" /></td>
				<td><sf:errors path="mobile" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><sf:password path="password" /></td>
				<td><sf:errors path="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>