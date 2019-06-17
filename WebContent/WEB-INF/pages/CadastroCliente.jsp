<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulário do Cadastro do Cliente</title>
		<link href="<c:url value="/resources/css/util/datatables.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/util/dataTables.bootstrap4.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/util/buttons.dataTables.min.css"/>" rel="stylesheet">
		<link href='<c:url value="/resources/css/util/bootstrap.min.css"></c:url>' rel="stylesheet">
		<link href="<c:url value="/resources/css/util/font-awesome.min.css"/>"rel="stylesheet">
		<link href="<c:url value="/resources/css/util/sweetalert2.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/projeto/cadastro.css"/>" rel="stylesheet">
	</head>
	<body>
		<div class="container-fluid">
			<div class="cabecalho-clientes">
				<div class="d-flex justify-content-center">
					<p class="display-4">Cadastro de Clientes</p>
				</div>
			</div>			<div class="conteudo">
					<div class="row">
						<div class="col">
							Nome:
							<input type="text" name="nome" class="form-control" id='nome'>
						</div>
					
						
					</div>
					<div class="row">
						<div class="col-4">
							CPF:
							<input type="text" name="cpf" class="form-control" id='cpf'/>
						</div>
						<div class="col-4">
							Telefone:
							<input type="text" name="telefone" class="form-control" id='telefone'/>
						</div>
					
					
						<div class="col-3">
							Data de nascimento:
							<input type="text" name="data_nascimento" class="form-control" id='data-nasc'/>
						</div>
					</div>
					<div class="row">
						<div class="col">
							Logradouro:
							<input type="text" name="endereco_cliente.nome" class="form-control" id='logradouro'>
						</div>
						
						<div class="col-3">
							Número:
							<input type="text" name="endereco_cliente.numero" class="form-control" id='numero'>
						</div>
						<div class="col-3">
							CEP:
							<input type="text" name="endereco_cliente.cep"class="form-control"/>
						</div>
					</div>
					<div>
						Email:
						<input type="text" name="email" class="form-control" id='email'/>
					</div>
					
					<div>
						Senha:
						<input type="text" name="senha" class="form-control" id='senha'/>
					</div>
					
					<div>
						Confirmar senha:
						<input type="text" name="confirmarSenha" class="form-control"/>
					</div>
						<div class="d-flex justify-content-center mt-5">
							<button id ="cadastrarCliente" class="btn btn-success btn-lg btn-block">Cadastrar</button>
						</div>
			</div>
		</div>
		
		<script src="<c:url value="/resources/js/util/jquery.min.js"/>"></script>
		<script src="<c:url value="/resources/js/util/popper.min.js"/>"></script>
		<script src="<c:url value="/resources/js/util/jquery.dataTables.min.js"/>"></script>
		<script src="<c:url value="/resources/js/util/bootstrap.min.js"/>"></script>
		<script src="<c:url value="/resources/js/projeto/cadastroCliente.js"/>"></script>		
	</body>
</html>