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
		<h1>Menu Utilizadores</h1>
	</header>

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
					</tr>

					<c:forEach items="${utilizadores}" var="u">
						<tr>
							<td>${u.idutilizador}</td>
							<td>${u.nome}</td>
							<td>${u.username}</td>
							<td>${u.email}</td>
							<td>${u.senha}</td>
							<td>${u.nivel}</td>
							<td><a class="btn btn-edit"
								href="${pageContext.request.contextPath }/utilizadores/editar?id=${u.id}">Editar</a></td>
							<td><a class="btn btn-edit"
								href="${pageContext.request.contextPath }/utilizadores/apagar?id=${u.id}"
								onclick="return confirm('Tem certeza que deseja apagar este utilizador?');">Apagar</a></td>
						</tr>
					</c:forEach>
				</table>
			</section>
		</main>

		<div class="card">

			<p>Bem vindo,
			<p>
				<strong>${sessionScope.utilizador.nome}</strong>
			</p>
		</div>


		<footer>
			<p>@ 2026 DBAstronómica</p>
		</footer>
</body>
</html>