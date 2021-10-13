/**
 * 
 */

function validar() {
	let nome = frmContato.nome.value;
	let genero = frmContato.selectGeneros.value;
	
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const operation = urlParams.get('operation')
	
	if (nome === "") {
		alert("Preencha  o campo 'Nome'")
		frmContato.nome.focus();
		return false;
	} else if (genero === "-selecione-") {
		alert("Preencha o campo 'Genero'")
		frmContato.selectGeneros.focus();
		return false;
	} else {
		operation ==="novo"? (document.forms["frmContato"].submit()) : alert('editar')
		
	}
}