<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listar Clientes</title>
	</head>
	<body>
	
		<h1>Listar Clientes</h1>
		
		<table border="1">
			<tr>
				<th>CPF:</th>
				<th>Nome:</th>
				<th>Telefone:</th>
				<th>Email:</th>
				<th>Data de nascimento:</th>
				<th>Endereço:</th>
				<th>Ação:</th>
			</tr>
			
			<c:forEach items="${clientes}" var="cliente">
			
				<tr>
					<td>${cliente.cpf}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.telefone}</td>
					<td>${cliente.email}</td>
					<td><fmt:formatDate value="${itemMotorista.data_nascimento}" pattern="MM/dd/yyyy" /></td>
					<td>${cliente.enderecoCliente.nome}</td>
					<td><a href="http://localhost:8080/AppDeMudancas/RemoverMotorista?cpf=${itemMotorista.cpf}">Remover</a></td>
				</tr>
			
			</c:forEach>
			
		</table>
			<script src="<c:url value="/resources/js/util/jquery.min.js"/>"></script>
			<script src="<c:url value="/resources/js/projeto/listarClientes.js"/>"></script>
	</body>
</html>