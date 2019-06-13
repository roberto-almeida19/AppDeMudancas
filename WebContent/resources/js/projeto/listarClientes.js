$(document).ready(function() {
	buscarClientes();
});


function buscarClientes() {
	jQuery.ajax({
		url : "listar/carros",
		type : "GET",
		async : false,
		success : function(result) {
			console.log(result);
		}
	});
}
