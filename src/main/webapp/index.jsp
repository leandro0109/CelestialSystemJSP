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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css">
</head>

<body>
	<header>
		<h1>Menu Principal</h1>
	</header>

	<div class="container">
		<nav>
			<a class="btn" href="${pageContext.request.contextPath}/utilizadores">Utilizadores</a> 
			<a class="btn" href="${pageContext.request.contextPath}/estrelas">Estrelas</a> 
			<a class="btn" href="${pageContext.request.contextPath}/planetas">Planetas</a>
						<a class="btn" href="${pageContext.request.contextPath}/logout"
				onclick="return confirm('Tem a certeza que quer fazer logout?');">Logout</a>
		</nav>
	</div>

	<footer>
		<p>@2026 DBAstronómica</p>
	</footer>
</body>
</html>