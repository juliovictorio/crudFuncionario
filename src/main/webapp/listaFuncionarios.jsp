<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de funcionarios</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<jsp:include page="cabecalho.jsp" />
		<div class="jumbotron">
			<h1>Lista de funcionários</h1>
			<table class="table-striped table-bordered">
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Salario</th>
					<th colspan="2">Ações</th>
				</tr>
				<c:forEach var="funcionario" items="${funcionarios}">
					<tr>
						<td>${funcionario.nome}</td>
						<td>${funcionario.email}</td>
						<td>${funcionario.salario}</td>
						<td><a
							href="Controller?command=EditarController&idFuncionario=${funcionario.id}">Editar</a>
						</td>
						<td><a
							href="Controller?command=ExcluirController&idFuncionario=${funcionario.id}">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
</html>