$(document).ready(function() {
	
	let info = [];
	info.push(buscarClientes());
	montarDataTable(info)
});
	
function buscarClientes() {
	return jQuery.ajax({
		url : "listar/clientes",
		type : "GET",
		async : false,
	}).responseJSON;
}
function montarDataTable(info) {
		$('#lista-clientes').DataTable({
		 	'paging':true,
			'data':info,
			'lengthMenu': [[10, 25, 50, -1], [10, 25, 50, "All"]],
			"pageLength": 20,
			
			'language': {
	    		"sProcessing":   "A processar...",
	    		"sLengthMenu":   "Mostrar _MENU_ registros",
	    		"sZeroRecords":  "Não foram encontrados resultados",
	    		"sInfo":         "Mostrando de _START_ até _END_ de _TOTAL_ registros",
	    		"sInfoEmpty":    "Mostrando de 0 até 0 de 0 registros",
	    		"sInfoFiltered": "(filtrado de _MAX_ registros no total)",
	    		"sInfoPostFix":  "",
	    		"sSearch":       "Procurar:",
	    		"sUrl":          "",
	    		"oPaginate": {
	    		    "sFirst":    "Primeiro",
	    		    "sPrevious": "Anterior",
	    		    "sNext":     "Seguinte",
	    		    "sLast":     "Último"
	    		},
			},
	    	
		 
		 "data":info,
		 'columns':[{'data':'nome'},{'data':'cpf'}, 
			 {'render': function(data,row,id) {
			return `<span class='fa fa-pencil'></span>`}},
			 {'render': function(data,row,id) {
			return `<span class='fa fa-trash'></span>`}},
					
			]
		});
	}

