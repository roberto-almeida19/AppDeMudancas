<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="formSpring" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulário do Motorista</title>
	</head>
	<body>

		<formSpring:form id="formularioDoMotorista" 
		method="post" modelAttribute="motorista">
			
			<div>
				<formSpring:label path="nome">Nome:</formSpring:label>
				<formSpring:input path="nome"/>
			</div>
	
			<div>
				<formSpring:label path="telefone">Telefone:</formSpring:label>
				<formSpring:input path="telefone"/>
			</div>
		
			<div>
				<formSpring:label path="cpf">Cpf:</formSpring:label>
				<formSpring:input path="cpf"/>
			</div>
		
			<div>
				<formSpring:label path="data_nascimento">Data de Nascimento:</formSpring:label>
				<formSpring:input path="data_nascimento"/>
			</div>
		
			<div>
				<formSpring:label path="cnh.numero">Nº de registro do CNH:</formSpring:label>
				<formSpring:input path="cnh.numero"/>
			</div>
			
			<!-- 
			<div>
				<formSpring:label path="cnh.foto">Foto da CNH:</formSpring:label>
				<formSpring:input type="file" path="cnh.foto"/>
			</div>
			-->
			
			<div>
				<formSpring:label path="quantidadeAjudantes">Quantiddade de Ajudantes:
				</formSpring:label>
				<formSpring:input path="quantidadeAjudantes"/>
			</div>
			
			<!--  -->
			<div>
				<formSpring:label path="endereco_motorista.numero">Número:</formSpring:label>
				<formSpring:input path="endereco_motorista.numero"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_motorista.nome">Nome:</formSpring:label>
				<formSpring:input path="endereco_motorista.nome"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_motorista.bairro">Bairro:</formSpring:label>
				<formSpring:input path="endereco_motorista.bairro"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_motorista.cidade">Cidade:</formSpring:label>
				<formSpring:input path="endereco_motorista.cidade"/>
			</div>
			
			<div>
				<formSpring:label path="endereco_motorista.uf">UF:</formSpring:label>
				<formSpring:input path="endereco_motorista.uf"/>
			</div>
			
			<div>
				<formSpring:label path="endereco_motorista.complemento">Complemento:</formSpring:label>
				<formSpring:input path="endereco_motorista.complemento"/>
			</div>
			
			<!--  -->
			
			<div>
				<formSpring:label path="email">Email:</formSpring:label>
				<formSpring:input path="email"/>
			</div>
	
			<div>
				<formSpring:label path="senha">Senha:</formSpring:label>
				<formSpring:input type="password" path="senha"/>
			</div>
			
			<!--  
			<div>
				<formSpring:label path="">Confirmar senha:</formSpring:label>
				<formSpring:input path=""/>
			</div>
			-->
			<formSpring:input type="submit" path="" value="Enviar"/>
		</formSpring:form>
		
		<button onclick="irParaListarMotorista()">Listar Motoristas</button>
		
		<script>
	
			var url = "http://localhost:8080/AppDeMudancas";
			function irParaListarMotorista(){
				window.location = url+"/ListarMotorista";			
			}
		
		</script>
			
	</body>
</html>