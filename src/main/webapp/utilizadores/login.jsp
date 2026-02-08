<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<%
	String erro = (String) request.getAttribute("erro");
	if (erro != null) {
	%>
	<div class="error"><%=erro%></div>
	<%
	}
	%>

	<header>
		<h1>Menu de Autenticação</h1>
	</header>

	<form method="post" action="<%=request.getContextPath()%>/login">
		<label>Username</label> <br> <input type="text" name="username"
			required><br>
		<br> <label>Password</label> <br> <input type="password"
			name="senha" required><br> <br>

		<button type="submit">Entrar</button>
	</form>
</body>
</html>