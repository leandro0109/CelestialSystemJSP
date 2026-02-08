<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/adicionar.css">
</head>
<body>

	<h2>Registrar Novo Utilizador</h2>

	<form method="post"
		action="<%=request.getContextPath()%>/criarUtilizador">
		<label>Nome</label><input type="text" name="nome" placeholder="Digite o nome" required>
		<p>
		<br>
			<label>Username</label><input type="text" name="username" placeholder="Digite o username"
				required>
		<p>
			<label>Senha</label><input type="password" name="senha" placeholder="Digite a senha"
				required>
		<p>
			<label>Email</label><input type="email" name="email" placeholder="Digite o email"
				required>
		<p>
			<label>Nivel Acesso</label><select name="nivel" required>
				<option value="user">User</option>
				<option value="admin">Admin</option>
			</select> <br>
		<p>
			<button type="submit">Inserir</button>
			<button type="reset">Limpar</button>
	</form>

</body>
</html>