<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${errorMsg}
	<form action="login" method="post">
		<input type="text" name="email" /> <input type="password"
			name="password" /> <input type="submit" />
	</form>

</body>
</html>