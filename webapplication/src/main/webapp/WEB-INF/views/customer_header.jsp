<%@page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>

<header>
	<nav>
		<ul>
			<li><a href="${contextPath}/home">Home</a></li>
			<li><a href="${contextPath}/customer/addstory">Add Story</a></li>
			<li><a href="${contextPath}/customer/mystories">My Stories</a></li>
			<li><a href="${contextPath}/customer/allstories">All Stories</a></li>
			<li><a href="${contextPath}/customer/profile">Profile</a></li>
			<li><a href="${contextPath}/logout">Logout</a>
		</ul>
	</nav>
</header>