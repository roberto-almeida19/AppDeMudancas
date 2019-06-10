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
		<title>Formulário do Cadastro dos Endereços da Mudança</title>
	</head>
	<body>

		<formSpring:form id="form3" action="" method="post" modelAttribute="cadastroMudanca1">
			<h1>Endereço de Origem:</h1>
			<div>
				<formSpring:label path="endereco_inicial.nome">Endereço*</formSpring:label>
				<formSpring:input path="endereco_inicial.nome"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_inicial.numero">Número*</formSpring:label>
				<formSpring:input path="endereco_inicial.numero"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_inicial.bairro">Bairro*</formSpring:label>
				<formSpring:input path="endereco_inicial.bairro"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_inicial.cidade">Cidade*</formSpring:label>
				<formSpring:input path="endereco_inicial.cidade"/>
			</div>
			
			<div>
				<formSpring:label path="endereco_inicial.uf">UF*</formSpring:label>
				<formSpring:input path="endereco_inicial.uf"/>
			</div>
			
			<div>
				<formSpring:label path="endereco_inicial.complemento">Complemento</formSpring:label>
				<formSpring:input path="endereco_inicial.complemento"/>
			</div>
			<h1>Endereço de Destino:</h1>
			<div>
				<formSpring:label path="endereco_final.nome">Endereço*</formSpring:label>
				<formSpring:input path="endereco_final.nome"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_final.numero">Número*</formSpring:label>
				<formSpring:input path="endereco_final.numero"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_final.bairro">Bairro*</formSpring:label>
				<formSpring:input path="endereco_final.bairro"/>
			</div>
		
			<div>
				<formSpring:label path="endereco_final.cidade">Cidade*</formSpring:label>
				<formSpring:input path="endereco_final.cidade"/>
			</div>
			
			<div>
				<formSpring:label path="endereco_final.uf">UF*</formSpring:label>
				<formSpring:input path="endereco_final.uf"/>
			</div>
			
			<div>
				<formSpring:label path="endereco_final.complemento">Complemento</formSpring:label>
				<formSpring:input path="endereco_final.complemento"/>
			</div>
			<formSpring:button>Enviar</formSpring:button>
			<formSpring:button>Voltar</formSpring:button>
		</formSpring:form>		
	</body>
</html>