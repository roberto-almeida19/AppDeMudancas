<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Essa anotação "taglib" é importante: ela vai permitir usarmos tags da biblioteca de 
formulario do spring. Esse atributo "uri" é o caminho onde devem ser pegas
as tags (no caso, do site do spring) e o "prefix" é só pra simplificar a forma que vamos 
usar essas tags (no nosso caso, sempre com o prefixo "formSpring" ao invés de ter que 
digitar todo o caminho do site do spring)-->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="formSpring" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulário do Cadastro do Carro</title>
	</head>
	<body>

		<formSpring:form id="form4" action="" method="post" modelAttribute="cadastroCarro">
	
			<div>
				<formSpring:label path="placa">Placa*</formSpring:label>
				<formSpring:input path="placa"/>
			</div>
		
			<div>
				<formSpring:label path="anoFabricacao">Ano de Fabricação*</formSpring:label>
				<formSpring:input path="anoFabricacao"/>
			</div>
		
			<div>
				<formSpring:label path="chassi">Chassi*</formSpring:label>
				<formSpring:input path="chassi"/>
			</div>
		
			<div>
				<formSpring:label path="marca">Marca*</formSpring:label>
				<formSpring:input path="marca"/>
			</div>
			
			<div>
				<formSpring:label path="modelo">Modelo*</formSpring:label>
				<formSpring:input path="modelo"/>
			</div>
			
			<div>
				<formSpring:label path="cor">Cor*</formSpring:label>
				<formSpring:input path="cor"/>
			</div>
			<formSpring:button>Adicionar</formSpring:button>
			<formSpring:button>Voltar</formSpring:button>
		</formSpring:form>		
	</body>
</html>