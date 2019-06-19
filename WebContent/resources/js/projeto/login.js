$(document).ready(function() {
	$('#btn-login-cliente').on('click', function() {
		abrirModalCliente();
	});
	$('#btn-login-motorista').on('click', function() {
		abrirModalMotorista();
	});
	$('#btn-cadastrar-cliente').on('click', function() {
		chamarTelaCadastroCliente();
	});
	$('#btn-cadastrar-motorista').on('click', function() {
		chamarTelaCadastroMotorista();
	})
	
});

function abrirModalCliente() {
	$('.modal-title').html('Login - Cliente');
	$('.modal-body').html(`<input type="text" id="ipt-username" name="username" autocomplete="off" placeholder="Email" class="form-control" />
							<input type="password" id="ipt-senha" placeholder="Senha" class="form-control mt-1" autocomplete="false"/>
							<button type="button" class="btn btn-default btn-block btn-custom mt-1" onclick="logar('cliente')">Login</button>`);
	$('#modal-login').modal('show');
	
}

function abrirModalMotorista() {
	$('.modal-body').html(`<input type="text" id="ipt-username" name="username" autocomplete="off" placeholder="Email" class="form-control" />
			<input type="password" id="ipt-senha" placeholder="Senha" class="form-control mt-1" autocomplete="false"/>
			<button type="button" class="btn btn-default btn-block btn-custom mt-1" onclick="logar('motorista')">Login</button>`);
	$('#modal-login').modal('show');
	$('.modal-title').html('Login - Motorista');
}

function chamarTelaCadastroCliente() {
	let form = document.createElement('form');
	$('.modal').append(form);
	form.setAttribute('method', 'get');
	form.setAttribute('action','CadastroCliente');
	form.submit();
}

function chamarTelaCadastroMotorista() {
	let form = document.createElement('form');
	$('.modal').append(form);
	form.setAttribute('method', 'get');
	form.setAttribute('action','CadastroMotorista');
	form.submit();
}




function logar(tipo){
	if (tipo == 'cliente') {
		jQuery.ajax({
			url : "loginCliente",
			type : "POST",
			async : false,
			data : {
				login : $('#ipt-username').val(),
				pass : $('#ipt-senha').val()
			},
			success : function(result) {
				if (result == 'OK') {
					let form = document.createElement('form');
					$('.modal').append(form);
					form.setAttribute('method', 'get');
					form.setAttribute('action','indexMotorista');
					form.submit();
				}
			}
		});
	} else {
		jQuery.ajax({
			url : "loginMotorista",
			type : "GET",
			async : false,
			data : {
				login : $('#ipt-username').val(),
				pass : $('#ipt-senha').val()
			},
			success : function(result) {
				console.log(result);
				if (result == 'OK') {
					let form = document.createElement('form');
					$('.modal').append(form);
					form.setAttribute('method', 'get');
					form.setAttribute('action','formularioMotorista');
					form.submit();
				}
			}
	});
	}
}
	
