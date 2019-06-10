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
		<title>Formulário do Cadastro do Cliente</title>
	</head>
	<body>

		<formSpring:form id="form2" action="" method="post" modelAttribute="cadastroCliente">
	
			<div>
				<formSpring:label path="nome">Nome*</formSpring:label>
				<formSpring:input path="nome"/>
			</div>
		
			<div>
				<formSpring:label path="telefone">Telefone*</formSpring:label>
				<formSpring:input path="telefone"/>
			</div>
		
			<div>
				<formSpring:label path="cpf">CPF*</formSpring:label>
				<formSpring:input path="cpf"/>
			</div>
		
			<div>
				<formSpring:label path="data_nascimento">Nascimento*</formSpring:label>
				<formSpring:input path="data_nascimento"/>
			</div>
			
			<div>
				<formSpring:label path="endereco_cliente.nome">Endereço*</formSpring:label>
				<formSpring:input path="endereco_cliente.nome"/>
			</div>
			
			<div>
				<formSpring:label path="endereco_cliente.numero">Número*</formSpring:label>
				<formSpring:input path="endereco_cliente.numero"/>
			</div>
			<div>
				<formSpring:label path="endereco_cliente.bairro">Bairro*</formSpring:label>
				<formSpring:input path="endereco_cliente.bairro"/>
			</div>
			<div>
				<formSpring:label path="endereco_cliente.cidade">Cidade*</formSpring:label>
				<formSpring:input path="endereco_cliente.cidade"/>
			</div>
			<div>
				<formSpring:label path="endereco_cliente.uf">UF*</formSpring:label>
				<formSpring:input path="endereco_cliente.uf"/>
			</div>
			<div>
				<formSpring:label path="endereco_cliente.complemento">Complemento</formSpring:label>
				<formSpring:input path="endereco_cliente.complemento"/>
			</div>
			<div>
				<formSpring:label path="email">Email*</formSpring:label>
				<formSpring:input path="email"/>
			</div>
			<div>
				<formSpring:label path="senha">Senha*:</formSpring:label>
				<formSpring:input path="senha"/>
			</div>
			<div>
				<formSpring:label path="senha">Confirmar senha*:</formSpring:label>
				<formSpring:input path="senha"/>
			</div>
			<formSpring:button>Enviar</formSpring:button>
			<formSpring:button>Voltar</formSpring:button>
		</formSpring:form>		
	</body>
</html>