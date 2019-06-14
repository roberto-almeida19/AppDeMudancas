$(document).ready(function() {
	buscarClientes();
});

	function buscarClientes() {
	jQuery.ajax({
		url : "listar/carros",
		type : "GET",
		dataType:'json',
		async : false,
		success : function(result) {
			console.log(result);
		}
	});
}
