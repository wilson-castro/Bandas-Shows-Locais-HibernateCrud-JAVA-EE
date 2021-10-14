/**
 * 
 */

function validar() {
	let nome = form.nome.value;
	let genero = form.selectGeneros.value;
	
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const operation = urlParams.get('operation')
	
	if (nome === "") {
		alert("Preencha  o campo 'Nome'")
		form.nome.focus();
		return false;
	} else if (genero === "-selecione-") {
		alert("Preencha o campo 'Genero'")
		form.selectGeneros.focus();
		return false;
	} else {
		(document.forms["form"].submit());
		
	}
}