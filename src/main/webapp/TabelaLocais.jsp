<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.ShowsLocal"%>
<%@ page import="model.beans.Show"%>
<%
//ArrayList<ShowsLocal> shows = (ArrayList<ShowsLocal>) request.getAttribute("shows");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de shows</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h1>Lista de Locais</h1>
	<a href="FormControlLocais?operation=novo" class="Botao1">Novo</a>
	
	<form name="form" action="insert">		
			
			<div class="filtros">
			
				<div id="inputNome">
					<input type="text" name="nome_lugar" placeholder="Digite o nome do lugar..." class="Caixa2">
					<input type="button" value="Pesquisar" class="Botao1" onclick="validar()">
					
				</div>
				
			</div>
				
		</form>

</body>
</html>