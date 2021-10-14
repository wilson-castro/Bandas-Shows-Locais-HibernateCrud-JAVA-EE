/**
 * 
 */

function confirmar(idBanda) {
	let resposta = confirm("Confirma a exclusão deste contato?")
	if (resposta === true) {
		window.location.href = "bandas/delete?idBanda=" + idBanda
	}
}