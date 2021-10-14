/**
 * 
 */

function confirmar(id) {
	let resposta = confirm("Confirma a exclusão deste item?")
	if (resposta === true) {
		window.location.href = "bandas/delete?idBanda=" + id
	}
}