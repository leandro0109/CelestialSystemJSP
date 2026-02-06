<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboardstyle.css">
</head>
<body>

	<form method="post" action="<%= request.getContextPath()%>/criarUtilizador">
	<label>Nome</label>
	<br>
	<input type ="text" name = "nome" required>
	<p>
	<label>Senha</label>
	<br>
	<input type ="password" name = "senha" required>
	<p>
	<label>Nivel Acesso</label>
	<br>
	<select name = "nivel" required>
	<option value = "user">User</option>
	<option value = "admin">Admin</option>
	</select>
	<p>
	
	<button type = "submit">Inserir</button>
</form>
</body>
</html>