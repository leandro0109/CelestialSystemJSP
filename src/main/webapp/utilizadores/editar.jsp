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
<title>Editar Clientes</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adicionar.css">
</head>

<body>

	<form method="post" action="${pageContext.request.contextPath }/editarUtilizador">
	<input type="hidden" name="id" value="${utilizador.idUtilizador}" required>
	<p>
	<label>Nome</label>
	<input type="text" name="nome" value="${utilizador.nome }" required>
	<p>
	<label>Username</label>
	<input type="text" name="username" value="${utilizador.username }" required>
	<p>
	<label>Email</label>
	<input type="email" name="email" value="${utilizador.email }" required>
	<p>
	<label>Senha (Opcional)</label>
	<input type="text" name="senha"><small>Deixe em branco para manter a senha atual</small>
	<p>
	<label>Nivel de Acesso</label>
	<select name="nivel" required>
	<option value="Admin" ${utilizador.nivel=="admin" }>Admin</option>
	<option value="User" ${utilizador.nivel=="user" }>User</option>
	</select>
	<br><br><br>
	
	<button type="submit">Guardar Alterações</button>
	</form>
	
</body>
</html>