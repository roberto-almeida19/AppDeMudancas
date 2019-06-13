$(document).ready(function() {
	$('#ipt-username').mask('A0000000');
	$('#ipt-senha').keyup(function(event) {
		if (event.keyCode === 13) {
			logar();
		}
	});
});

function salvarSenha() {
	let iptSenhaNova = $('#ipt-senha-nova');
	let iptSenha = $('#ipt-senha');
	
	let username = $('#ipt-username').val();
	let senhaNova = iptSenhaNova.val();
	let senhaConfirma = $('#ipt-senha-confirma').val();
	
	if (senhaNova != '' && senhaConfirma != '') {
		if (senhaNova == senhaConfirma) {
			jQuery.ajax({
				url : "alterar_senha",
				type : "POST",
				data : {
					username: username,
					senha: md5(senhaNova),
					senhaAntiga: md5(iptSenha.val())
				},
				async : false,
				success : function(data) {
					$.bootstrapGrowl('Senha alterada com sucesso', {type: 'success'});
					iptSenha.val(senhaNova);
					$('#btn-logar').trigger('click');
				},
				error : function() {
					$.bootstrapGrowl('Ocorreu um erro ao alterar a senha!', {type: 'danger'});
				}
			});
		} else {
			$.bootstrapGrowl('Senhas Diferentes!', {type: 'danger'});
		}
	} else {
		$.bootstrapGrowl('Por favor, preencha todos os campos!', {type: 'warning'});
	}
}

function logar() {
	var iptUsername = $('#ipt-username');
	var iptSenha = $('#ipt-senha');
	var iptCript = $('#ipt-cript');
	
	var username = iptUsername.val();
	var senha = md5(iptSenha.val());
	
	if (username != '' && senha != '') {
		$.ajax({
			url: 'validar_usuario',
			method: 'POST',
			async: false,
			data: {
				username: username,
				senha: senha
			},
			success: function(data) {
				$.bootstrapGrowl('<span style="font-size: 16px;"> Autenticando...<span>', {type: 'success'});
				iptCript.val(senha);
				setTimeout(() => {
					$('#form-login').submit();
				}, 1000);
			},
			error: function(errorCode) {
				if (errorCode.status == 500) {
					$.bootstrapGrowl('Seu usuário não possui acesso a este sistema!', {type: 'danger'});
				} else if (errorCode.status == 404) {
					$.bootstrapGrowl('Nome de usuário ou/e senha incorretos!', {type: 'danger'});
				} else if (errorCode.status == 400) {
					$.bootstrapGrowl('Seu usuário encontra-se bloqueado!', {type: 'danger'});				
				} else if(errorCode.status == 415) {
					$.bootstrapGrowl('Aguarde a validação de seu usuário!', {type: 'warning'});		
				} else {
					$('#modal-reset').modal();
				}
			}
		});
	} else {
		$.bootstrapGrowl('Preencha os campos!', {type: 'warning'});
	}
}

