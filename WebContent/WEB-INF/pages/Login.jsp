<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
		<link href="<c:url value="/resources/css/util/datatables.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/util/dataTables.bootstrap4.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/util/buttons.dataTables.min.css"/>" rel="stylesheet">
		<link href='<c:url value="/resources/css/util/bootstrap.min.css"></c:url>' rel="stylesheet">
		<link href="<c:url value="/resources/css/util/font-awesome.min.css"/>"rel="stylesheet">
		<link href="<c:url value="/resources/css/util/sweetalert2.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/projeto/login.css"/>" rel="stylesheet">
</head>
<body>
<div class="modal" tabindex="-1" role="dialog" id='modal-login'>
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      </div>
    </div>
  </div>
</div>
<div class="container-fluid" id="plano-fundo">
	<div class="login-box">
		 <div class=" row">
		 	<div class="col">
				<button class="btn btn-warning"  id="btn-login-cliente">Logar como Cliente</button>
				<button class="btn btn-warning mt-2" id="btn-cadastrar-cliente">Cadastrar como Cliente</button>
			</div>
			<div class="col">
				<button class="btn btn-success" id="btn-login-motorista">Logar como Motorista</button>
			<button class="btn btn-success mt-2" id="btn-cadastrar-motorista">Cadastrar como Motorista</button>
			</div>
		</div>			
	</div>
</div>	



	<script src='<c:url value="/resources/js/util/jquery.min.js"/>'></script>
	<script src='<c:url value="/resources/js/util/popper.min.js"/>'></script>
	<script src='<c:url value="/resources/js/util/jquery.dataTables.min.js"/>'></script>
	<script src='<c:url value="/resources/js/util/bootstrap.min.js"/>'></script>
	<script src='<c:url value="/resources/js/projeto/login.js"/>'></script>
</body>
</html>