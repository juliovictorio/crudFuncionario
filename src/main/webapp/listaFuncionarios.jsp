<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de funcionarios</title>
<style type="text/css" src="css/estilo.css" ></style>
</head>
<body>
	<h1>Lista de funcionários</h1>
	<table>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Salario</th>
		</tr>
		<c:forEach var="funcionario" items="${funcionarios}">
			<tr>
				<td>${funcionario.nome}</td>
				<td>${funcionario.email}</td>
				<td>${funcionario.salario}</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="Controller?command=AbrirCadastroController">
			Cadastro de funcionários
		</a>
	</p>
</body>
</html>