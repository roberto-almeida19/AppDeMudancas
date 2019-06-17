$(document).ready(function() {
	$('#btn-login-cliente').on('click', function() {
		abrirModalCliente();
	});
	$('#btn-login-motorista').on('click', function() {
		abrirModalMotorista();
	});
});

function abrirModalCliente() {
	$('.modal-title').html('Login - Cliente');
	$('.modal-body').html(`<input type="text" id="ipt-username" name="username" autocomplete="off" placeholder="Email" class="form-control" />
							<input type="password" id="ipt-senha" placeholder="Senha" class="form-control mt-1" autocomplete="false"/>
							<button type="button" class="btn btn-default btn-block btn-custom mt-1" onclick="logar('cliente')">Login</button>`);
	$('#modal-login').modal('show');
	
}

function abrirModalMotorista() {
	$('#modal-login').modal('show');
	$('.modal-title').html('Login - Motorista');
}


function logar(tipo){
	if (tipo == 'cliente') {
		jQuery.ajax({
			url : "url",
			type : "POST",
			async : false,
			data : {
				id : id
			},
			success : function(result) {
				console.log(result);
			}
		});
	} else {
		jQuery.ajax({
			url : "url",
			type : "POST",
			async : false,
			data : {
				id : id
			},
			success : function(result) {
				console.log(result);
			}
		});
	}
	
}