<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<link href="<c:url value="/resources/css/util/datatables.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/util/dataTables.bootstrap4.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/util/buttons.dataTables.min.css"/>" rel="stylesheet">
		<link href='<c:url value="/resources/css/util/bootstrap.min.css"></c:url>' rel="stylesheet">
		<link href="<c:url value="/resources/css/util/font-awesome.min.css"/>"rel="stylesheet">
		<link href="<c:url value="/resources/css/util/sweetalert2.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/projeto/lista.css"/>" rel="stylesheet">
		<meta charset="UTF-8">
		<title>Listar Clientes</title>
	</head>
	<body>
		<div class="container-fluid" >
			<div class="cabecalho-listas">
				<div class="d-flex justify-content-center">
					<p class="display-4">Listagem de Clientes</p>
				</div>
			</div>
			<div id = "conteudo">
				<div class="d-flex justify-content-center">
					<table id="lista-clientes" class="display lista" style="width:100%">
						<thead>
							<tr>
								<th>Nome</th>
								<th>CPF</th>
							</tr>
						</thead>
					</table>		
				</div>
			</div>
		</div>	
			<script src="<c:url value="/resources/js/util/jquery.min.js"/>"></script>
			<script src="<c:url value="/resources/js/util/popper.min.js"/>"></script>
			<script src="<c:url value="/resources/js/util/jquery.dataTables.min.js"/>"></script>
			<script src="<c:url value="/resources/js/util/bootstrap.min.js"/>"></script>
			<script src="<c:url value="/resources/js/projeto/listarClientes.js"/>"></script>
	</body>
</html>