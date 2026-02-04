<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if (session == null || session.getAttribute("utilizador") == null) {
	response.sendRedirect(request.getContextPath() + "/index.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
	<h1>Menu Principal</h1>
		<nav>
			<a href = "utilizadores/dashboard.jsp">Gerir Utilizadores</a>
			<a href = "">Logout</a>
		</nav>
	</header>

	<footer>
		<p> @ 2026 DBAstronómica</p>
	</footer>
</body>
</html>