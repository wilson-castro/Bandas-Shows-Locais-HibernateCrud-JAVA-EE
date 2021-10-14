<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.Banda"%>
<%
ArrayList<Banda> bandas = (ArrayList<Banda>) request.getAttribute("bandas");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de bandas</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h1>Lista de bandas</h1>
		<a href="FormControlBandas?operation=novo" class="Botao1">Novo</a>

		<form name="form" action="insert">		
			
			<div class="filtros">
			
				<div id="inputNome">
					<input type="text" name="nome" placeholder="Digite um nome..." class="Caixa2">
		<a href="FormControlBandas?operation=novo" class="Botao1">Pesquisar</a>
					
				</div>
				
				<div class="group-checkbox">
					<input type="checkbox" id="ROCK" name="ROCK" value="ROCK">
					    <label for="vehicle1"> ROCK</label>
					<input type="checkbox" id="FORRO" name="FORRO" value="FORRO">
						<label for="vehicle2"> FORRÓ</label>
					 <input type="checkbox" id="AXE" name="AXE" value="AXE">
						<label for="vehicle3"> AXÉ</label>
				</div>
				
			</div>
				
		</form>

	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Genero</th>
				<th>Nº de Shows</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Banda banda : bandas) {
			%>
			<tr>
				<td><%=banda.getIdBanda()%></td>
				<td><%=banda.getNome()%></td>
				<td><%=banda.getGenero()%></td>
				<td><%=banda.getNumShows()%></td>
				<td>
					<a href="select?idBanda=<%= banda.getIdBanda() %>" class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%= banda.getIdBanda() %>)" class="Botao2">Excluir</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>