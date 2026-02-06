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
<title>Menu Principal</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboardstyle.css">
</head>

<body>
	<header>
	<h1>Menu Principal</h1>
		<nav>
			<a href="${pageContext.request.contextPath}/utilizadores">Gerir Utilizadores</a>
			<a href="${pageContext.request.contextPath}/logout"
			onclick="return confirm('Tem a certeza que quer fazer logout?');">Logout</a>
		</nav>
	</header>

	<footer>
		<p> @ 2026 DBAstronómica</p>
	</footer>
</body>
</html>