<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.ShowsLocal"%>
<%@ page import="model.beans.Show"%>
<%
ArrayList<ShowsLocal> shows = (ArrayList<ShowsLocal>) request.getAttribute("shows");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de shows</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h1>Lista de shows</h1>
	<a href="FormControlShows?operation=novo" class="Botao1">Novo</a>

		<form name="form" action="insert">		
			
			<div class="filtros">
			
				<div id="inputNome">
					<input type="text" name="nome" placeholder="Digite um lugar..." class="Caixa2">
					<input type="button" value="Pesquisar" class="Botao1" onclick="validar()">
					
				</div>
				
			</div>
				
		</form>

	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>ONDE</th>
				<th>Data do Show</th>
				<th>Capacidade</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (ShowsLocal show : shows) {
			%>
			<tr>
				<td><%=show.getShow_Id()%></td>
				<td><%=show.getLugar_nome()%></td>
				<td><%=show.getData_show()%></td>
				<td><%=show.getCapacidade()%></td>
				<td>
					<a href="select?idBanda=<%= show.getShow_Id() %>" class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%= show.getShow_Id() %>)" class="Botao2">Excluir</a>
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