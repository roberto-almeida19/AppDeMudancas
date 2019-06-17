<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index - Motorista</title>
<link rel="stylesheet" href='<c:url value="/resources/assets/css/material-dashboard.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/resources/css/util/bootstrap.min.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/resources/css/util/font-awesome.min.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/resources/css/projeto/indexMotorista.css"></c:url>'>
</head>
<body>
<div class="modal" tabindex="-1" role="dialog" id='modal-mudanca'>
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      
      
      
      
      
      
      </div>
    </div>
  </div>
</div>












<div class="wrapper">
	<div class="sidebar" data-color="blue" data-background-color="white" data-image='<c:url value="/resources/assets/img/new_logo.png"></c:url>'>
		<div class="logo">
			<a href='<c:url value="/private/index"></c:url>'> 
				<img src='<c:url value="/resources/assets/img/new_logo.png"></c:url>' class="img-responsive" style="padding: 15px;" />
			</a>
		</div>
		<div class="sidebar-wrapper">
			<ul class="nav">
				<li class="nav-item">
					<i class="fa fa-exchange"></i> <p>Alterar Cadastro</p></a>
				</li>
				<li class="nav-item">
					<i class="fa fa-exchange"></i><p>Alterar/Incluir Carro</p>
				</li>
				<li class="nav-item">
				 	<i class="fa fa-exchange"></i> <p>Alterar/Incluir Ajudantes</p>
				</li>
			</ul>
		</div>
	</div>
	<div class="main-panel">
		<nav class="navbar navbar-absolute">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse">
						<span class="sr-only">Abrir Navegação</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">${brand }</a>
				</div>
				<div class="collapse navbar-collapse">
				
				<!-- Ajustar o botão com CSS para a direita -->
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href='<c:url value="/public/logoff"></c:url>'> <i class="fa fa-sign-out"></i>
								<p class="hidden-lg hidden-md">Sair</p>
							</a>
						</li>
						<li class="separator hidden-lg hidden-md"></li>
					</ul>
					
					
				</div>
			</div>
		</nav>
		<div class="content" style="height: 100vh !important">		
			<div class="card proposta-mudanca">
				<div class="card-image">
					<img class="rounded mx-auto d-block" src='<c:url value="/resources/assets/img/card-3.jpg"></c:url>'>
				</div>
				<div class="card-content">
					<div class="card-title"><p class="">Mudancinha</div>
					<div class="card-description"><p class="">Mudança para a casa do caralho</div>
				
				</div>
				<div class="card-footer">
					<div class="price">Preço da mudança: R$1500</div>
					<div class="controls">
						<i class="fa fa-close fa-2x" style='color:red;'></i>
						<i class="fa fa-check fa-2x" style='color:green;'></i>
					
					</div>
				</div>
			
			</div>	
		</div>
	</div>
</div>
<script src='<c:url value="/resources/js/util/jquery.min.js"></c:url>' type="text/javascript"></script>
<script src='<c:url value="/resources/js/util/popper.min.js"></c:url>' type="text/javascript"></script>
<script src='<c:url value="/resources/js/util/jquery-ui.js"></c:url>' type="text/javascript"></script>
<script src='<c:url value="/resources/js/util/bootstrap.min.js"></c:url>' type="text/javascript"></script>
<script src='<c:url value="/resources/assets/js/core/bootstrap-material-design.min.js"></c:url>' type="text/javascript"></script>
<script src='<c:url value="/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></c:url>' type="text/javascript"></script>
<script src='<c:url value="/resources/js/projeto/indexMotorista.js"></c:url>' type="text/javascript"></script>
</body>
</html>