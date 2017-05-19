<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Cadastro</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#gerente").hide();
	$("#secretaria").hide();


	$("#tipoFuncionario").on('change', function() {
	    var tipoFuncionarioSelecionado = $(this).find(":selected").val();
		if(tipoFuncionarioSelecionado == "GERENTE"){
			$("#gerente").show();
			$("#secretaria").hide();
		}else{
			$("#gerente").hide();
			$("#secretaria").show();
		}
	});

});

</script>
</head>
<body>
	<h1>Cadastro de Funcionarios</h1>

	<form action="Controller" method="POST">

		<label for="nome">Nome</label><br/>
		<input type="text" name="nome" id="nome" /><br/><br/>
		
		<label for="email">Email</label><br/>
		<input type="text" name="email" id="email" /><br/><br/>
		
		<label for="senha">Senha</label><br/>
		<input type="password" name="senha" id="senha" /><br/><br/>
		
		<label for="salario">Salário</label><br/>
		<input type="text" name="salario" id="salario" /><br/><br/>
		
		<label for="departamento">Departamento</label><br/>
		<select name="departamento">
			<c:forEach var="departamento" items="${departamentos}">
				<option value="${departamento.id}">${departamento.nomeDepartamento}</option>
			</c:forEach>
		</select>	
		<br/><br/>
			<label for="tipoFuncionario">Tipo de Funcionario</label><br/>
			<select name="tipoFuncionario" id="tipoFuncionario">
				<option value="GERENTE">Gerente</option>
				<option value="SECRETARIA">Secretária</option>
			</select>		
			<br/><br/>
		<div id="gerente">
			<label for="bonificacao">Bonificação</label><br/>
			<input type="text" name="bonificacao" id="bonificacao" /><br/><br/>
		</div>
		<div id="secretaria">
			<label for="falaIngles">Fala inglês?</label><br/>
			<select name="falaIngles">
				<option value="true">Fala</option>
				<option value="false">Não fala</option>
			</select>		
			<br/><br/>
			<label for="periodoTrabalho">Fala inglês?</label><br/>
			<select name="periodoTrabalho">
				<option value="MANHA">Manhã</option>
				<option value="TARDE">Tarde</option>
				<option value="NOITE">Noite</option>
			</select>
			<br/><br/>
		</div>
		
		<input type="hidden" name="command" value="CadastrarController">
		<input type="submit" value="Cadastrar">
		
	</form>
	
	<p>${mensagem}</p>
</body>
</html>