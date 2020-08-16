<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@page import="java.sql.DriverManager"%>
<%
	String name = request.getParameter("firstname");
String username = request.getParameter("username");
String password = request.getParameter("password");

DriverManager.registerDriver(new Driver());
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdemo", "root", "root");

PreparedStatement ps = con.prepareStatement("insert into user(firstname,username,password) values(?,?,?)");

ps.setString(1, name);
ps.setString(2, username);
ps.setString(3, password);

int count = ps.executeUpdate();

if (count > 0) {
	response.sendRedirect("login.jsp");
} else {
	request.setAttribute("errorMessage", "Some internal error occured. Try again");
	request.getRequestDispatcher("registration.jsp").forward(request, response);
}
%>