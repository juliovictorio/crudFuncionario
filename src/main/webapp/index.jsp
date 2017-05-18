<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h1>Cadastro</h1>

	<form action="Controller" method="POST">

		<label for="nome">Nome</label><br/>
		<input type="text" name="nome" id="nome" /><br/>
		<label for="email">Email</label><br/>
		<input type="text" name="email" id="email" /><br/>
		<input type="hidden" name="command" value="CadastrarController">
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>