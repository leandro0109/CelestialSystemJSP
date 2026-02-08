<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>Utilizadores DBAstronómica</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css">
</head>
<body>

	<a href="${pageContext.request.contextPath}/index.jsp"
		class="btn-voltar">Voltar</a>

	<div class="card">

		<p>Bem vindo,</p>
		<strong>${sessionScope.utilizador.nivel}</strong>
		<p>
			<strong>${sessionScope.utilizador.nome}</strong>
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/logout"
				class="btn btn-apagar"
				onclick="return confirm('Tem a certeza que quer fazer logout?');">Logout</a>
		</p>
	</div>

	<main>
		<section>
			<p>
				<a
					href="${pageContext.request.contextPath }/utilizadores/adicionar.jsp"
					class="btn btn-edit">+ Novo Cliente</a>
			</p>

			<table border="1">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Username</th>
					<th>Email</th>
					<th>Senha</th>
					<th>Nivel</th>
					<th>Ações</th>
				</tr>

				<c:forEach items="${utilizadores}" var="u">
					<tr>
						<td>${u.idUtilizador}</td>
						<td>${u.nome}</td>
						<td>${u.username}</td>
						<td>${u.email}</td>
						<td>${u.senha}</td>
						<td>${u.nivel}</td>
						<td><a class="btn btn-edit"
							href="${pageContext.request.contextPath }/editarUtilizador?id=${u.idUtilizador}">
								Editar </a> <a class="btn btn-apagar"
							href="${pageContext.request.contextPath }/apagarUtilizador?id=${u.idUtilizador}"
							onclick="return confirm('Tem certeza que deseja apagar este utilizador?');">
								Apagar </a></td>
					</tr>
				</c:forEach>

			</table>
		</section>
	</main>

	<footer>
		<p>@2026 DBAstronómica</p>
	</footer>
</body>
</html>