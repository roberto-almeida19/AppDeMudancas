<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulário do Motorista</title>
	</head>
	<body>

		<form action="cadastrarMotorista" method="post">
			
			<div>
				Nome:
				<input type="text" name="nome"/>
			</div>
	
			<div>
				Telefone:
				<input type="text" name="telefone"/>
			</div>
		
			<div>
				CPF:
				<input type="text" name="cpf"/>
			</div>
		
			<div>
				Data de nascimento:
				<input type="text" name="data_nascimento"/>
			</div>
		
			<div>
				Nº de registro da CNH:
				<input type="text" name="cnh.numero"/>
			</div>
			
			<!-- 
			<div>
				<formSpring:label path="cnh.foto">Foto da CNH:</formSpring:label>
				<formSpring:input type="file" path="cnh.foto"/>
			</div>
			-->
			
			<div>
				Quantidade de ajudantes:
				<input type="text" name="quantidadeAjudantes"/>
			</div>
			
			<!--  -->
			<div>
				Número:
				<input type="text" name="endereco_motorista.numero"/>
			</div>
		
			<div>
				Nome:
				<input type="text" name="endereco_motorista.nome"/>
			</div>
		
			<div>
				CEP:
				<input type="text" name="endereco_motorista.cep"/>
			</div>
			
			<!--  -->
			
			<div>
				Email:
				<input type="text" name="email"/>
			</div>
	
			<div>
				Senha:
				<input type="password" name="senha"/>
			</div>
			
			<!--  
			<div>
				<formSpring:label path="">Confirmar senha:</formSpring:label>
				<formSpring:input path=""/>
			</div>
			-->
			<input type="submit" value="Enviar"/>
		</form>
		
		<button onclick="irParaListarMotorista()">Listar Motoristas</button>
		
		<c:out value="${msg}"></c:out>
		
		<script>
	
			var url = "http://localhost:8080/AppDeMudancas";
			function irParaListarMotorista(){
				window.location = url+"/ListarMotorista";			
			}
		
		</script>
			
	</body>
</html>