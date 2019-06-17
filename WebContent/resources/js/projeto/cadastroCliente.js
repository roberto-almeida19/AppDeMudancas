$(document).ready(function() {
	$('#cadastrarCliente').on('click', function() {
		let objecto = montarObjetos();
		cadastrarCliente(objecto.cliente, objecto.endereco);
	});
});


function montarObjetos() {
	let cliente = {};
	let endereco = {};
	cliente = {nome:$('#nome').val()};
	endereco = {nome: $('#logradouro').val()};
	let	objeto={cliente,endereco};
	return objeto;
}






function cadastrarCliente(cliente,endereco) {
	jQuery.ajax({
		url : "cadastrarCliente",
		type : "POST",
		async : false,
		data : {
			cliente,endereco
		},
		success : function(result) {
			console.log(result);
		}
	});
}