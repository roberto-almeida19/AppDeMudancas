<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulário do Cadastro do Cliente</title>
	</head>
	<body>

		<form action="cadastrarCliente" method="post">
	
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
				Logradouro:
				<input type="text" name="endereco_cliente.nome"/>
			</div>
			
			<div>
				Número:
				<input type="text" name="endereco_cliente.numero"/>
			</div>
			
			<div>
				CEP:
				<input type="text" name="endereco_cliente.cep"/>
			</div>
			<div>
				Email:
				<input type="text" name="email"/>
			</div>
			
			<div>
				Senha:
				<input type="text" name="senha"/>
			</div>
			
			<div>
				Confirmar senha:
				<input type="text" name="confirmarSenha"/>
			</div>
			<input type="submit" value="Enviar"/>
		</form>		
	</body>
</html>