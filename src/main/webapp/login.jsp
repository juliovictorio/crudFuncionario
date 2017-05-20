<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login do sistema</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Login do sistema</h1>
			<form action="Controller" method="POST">
				<input type="hidden" name="command" value="LogarController">
				<label for="email">Email</label><br /> <input type="text"
					name="email" id="email" /><br /> <label for="senha">Senha</label><br />
				<input type="password" name="senha" id="senha"/>
				<br />
				<br /> 
				<input type="submit" value="Logar" class="btn btn-lg btn-primary">
			</form>
			${mensagem}
		</div>
	</div>
</body>
</html>