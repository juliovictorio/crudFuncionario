<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Cadastro</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript">
	$(document).ready(function() {
		$("#div_gerente").hide();
		$("#div_secretaria").hide();

		/* var tipoFuncionario = $('#tipoFuncionarioHidden').val();
		if (tipoFuncionario == 'GERENTE') {
			$("#tipoFuncionario").val('GERENTE');
		} */

		$("#tipoFuncionario").on('change', function() {
			var tipoFuncionarioSelecionado = $(this).find(":selected").val();
			if (tipoFuncionarioSelecionado == "GERENTE") {
				$("#div_gerente").show();
				$("#div_secretaria").hide();
			} else {
				$("#div_gerente").hide();
				$("#div_secretaria").show();
			}
		});
		var idFuncionario = $('#idFuncionario').val();
		if (idFuncionario) {
			$("#div_senha").hide();
		}
	});
</script>
</head>
<body>
<div class="container">
	<jsp:include page="cabecalho.jsp" />
	<h1>Cadastro de Funcionarios</h1>

	<form action="Controller" method="POST">
		
		<div class="form-group col-6" id="div_nome">
			<label for="nome">Nome</label> 
			<input type="text" name="nome" id="nome" value="${funcionario.nome}" class="form-control" />
		</div>
		<div class="form-group col-6" id="div_email">
			<label for="email">Email</label> 
			<input type="text" name="email" id="email" value="${funcionario.email}"  class="form-control" />
		</div>
		<div class="form-group col-6" id="div_senha">
			<label for="senha">Senha</label> 
			<input type="password" name="senha" id="senha" value="${funcionario.senha}"  class="form-control" />
		</div>
		<div class="form-group col-6" id="div_salario">
			<label for="salario">Salário</label>
			<input type="text" name="salario" id="salario" value="${funcionario.salario}" class="form-control" />
		</div>
		<div class="form-group col-6" id="div_departamento">
			<label for="departamento">Departamento</label> 
			<select name="departamento" class="form-control">
				<c:forEach var="departamento" items="${departamentos}">
					<option value="${departamento.id}">${departamento.nomeDepartamento}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group col-6" id="div_salario">
			<label for="salario">Salário</label>
			<input type="text" name="salario" id="salario" value="${funcionario.salario}" class="form-control" />
		</div> 
		 <div class="form-group col-6" id="div_tipo_funcionario">
				<label for="tipoFuncionario">Tipo de Funcionario</label><br/>
				<select name="tipoFuncionario" id="tipoFuncionario" class="form-control">
					<option value="GERENTE">Gerente</option>
					<option value="SECRETARIA">Secretária</option>
				</select>
			</div> 
		<c:if test="${tipoFuncionario == null || tipoFuncionario eq 'GERENTE'}">
			<div class="form-group col-6" id="div_gerente">
				<label for="bonificacao">Bonificação</label>
				<input type="text" name="bonificacao" id="bonificacao" value="${funcionario.bonificacao}" class="form-control"/>
			</div> 
		</c:if>
		<c:if test="${tipoFuncionario == null || tipoFuncionario eq 'SECRETARIA'}">
			<div id="div_secretaria">
				<div class="form-group col-6">
					<label for="falaIngles">Fala inglês?</label>
					<select name="falaIngles" class="form-control">
						<option value="true">Fala</option>
						<option value="false">Não fala</option>
					</select>
				</div>
				<div class="form-group col-6" id="div_periodo">
					<label for="periodoTrabalho">Turno</label>
				<select name="periodoTrabalho" class="form-control">
					<option value="MANHA">Manhã</option>
					<option value="TARDE">Tarde</option>
					<option value="NOITE">Noite</option>
				</select>
				</div>
			</div>
		</c:if>
		<div class="form-group col-6" id="div_btn">
			<input type="hidden" name="command" value="CadastrarController">
			<input type="hidden" name="idFuncionario" id="idFuncionario" value="${funcionario.id}">
			<input type="hidden" name="tipoFuncionarioHidden" id="tipoFuncionarioHidden" value="${tipoFuncionario}">
			<input type="submit" value="Cadastrar" class=" btn btn-primary">
		</div>


	</form>

	<p>${mensagem}</p>

</div>
</body>
</html>