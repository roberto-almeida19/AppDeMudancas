<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listar Motoristas</title>
	</head>
	<body>
	
		<h1>Listar Motoristas</h1>
		
		<table border="1">
			<tr>
				<th>CPF:</th>
				<th>Nome:</th>
				<th>Telefone:</th>
				<th>Email:</th>
				<th>Data de nascimento:</th>
				<th>CNH:</th>				
				<th>Endereço:</th>
				<th>Ação:</th>
			</tr>
			
			<c:forEach items="${motoristas}" var="itemMotorista">
			
				<tr>
					<td>${itemMotorista.cpf}</td>
					<td>${itemMotorista.nome}</td>
					<td>${itemMotorista.telefone}</td>
					<td>${itemMotorista.email}</td>
					<td><fmt:formatDate value="${itemMotorista.data_nascimento}" pattern="MM/dd/yyyy" /></td>
					<td>${itemMotorista.cnh.numero}</td>
					<td>${itemMotorista.endereco_motorista.nome}</td>
					<td><a href="http://localhost:8080/AppDeMudancas/RemoverMotorista?cpf=${itemMotorista.cpf}">Remover</a></td>
				</tr>
			
			</c:forEach>
			
		</table>
			
	</body>
</html>