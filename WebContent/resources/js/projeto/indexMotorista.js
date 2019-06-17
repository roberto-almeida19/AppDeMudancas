$(document).ready(function() {
	$('.proposta-mudanca').on('click', function(){
		montarModalMudanca($(this)[0])
	});
});

 function montarModalMudanca(objeto) {
	 console.log(objeto);
	 let jObjeto = $(objeto);
	 console.log(jObjeto);
	 $('.modal-title').append();
	 $('.modal-body').append(objeto);
	 
	 $('#modal-mudanca').modal('show');
	 
	 
}