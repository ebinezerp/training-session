
<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");

DriverManager.registerDriver(new Driver());
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdemo", "root", "root");

PreparedStatement ps = con.prepareStatement("select * from user where username=? and password = ?");
ps.setString(1, username);
ps.setString(2, password);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
%>
<table>

	<tr>
		<td>First name</td><td><%=rs.getString("firstname")%></td>
	</tr>
	<tr>
		<td>Username</td><td><%=rs.getString("username")%></td>
	</tr>
</table>

<%
	}
%>
