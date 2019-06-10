<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="formSpring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<formSpring:form id="formularioDeLogin" method="post"
		modelAttribute="motorista">

		<div>
			<formSpring:label path="nome">Nome:</formSpring:label>
			<formSpring:input path="nome" />
		</div>

		<div>
			<formSpring:label path="senha">Senha:</formSpring:label>
			<formSpring:input type="password" path="senha" />
		</div>

		<formSpring:input type="submit" path="" value="Enviar" />
	</formSpring:form>
	
	<script>
		
	</script>

</body>
</html>