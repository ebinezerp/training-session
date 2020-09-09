<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>

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
		<sf:form action="addstory" method="POST" modelAttribute="story">
			<table>
				<tr>
					<td><label>Story Title</label></td>
					<td><sf:input path="title" /></td>
					<td><sf:errors path="title" /></td>
				</tr>
				<tr>
					<td colspan="2"><label>Story Content</label></td>
				</tr>
				<tr>
					<td colspan="2"><sf:errors path="content" /></td>
				</tr>
				<tr>
					<td colspan="2"><sf:textarea path="content" rows="25"
							cols="20" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="ADD STORY" /></td>
				</tr>
			</table>
		</sf:form>
	</section>


</body>
</html>