<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulário do Cadastro dos Endereços da Mudança</title>
	</head>
	<body>

		<form action="cadastrarMudanca" method="post">
			<h1>Endereço de Origem:</h1>
			<div>
				Logradouro:
				<input type="text" name="endereco_inicial.nome"/>
			</div>
		
			<div>
				Número:
				<input type="text" name="endereco_inicial.numero"/>
			</div>
		
			<div>
				CEP:
				<input type="text" name="endereco_inicial.cep"/>
			</div>
		
			<h1>Endereço de Destino:</h1>
			<div>
				Logradouro:
				<input type="text" name="endereco_destino.nome"/>
			</div>
		
			<div>
				Número:
				<input type="text" name="endereco_destino.numero"/>
			</div>
		
			<div>
				CEP:
				<input type="text" name="endereco_destino.cep"/>
			</div>
			<input type="submit" value="Enviar" />
		</form>		
	</body>
</html>