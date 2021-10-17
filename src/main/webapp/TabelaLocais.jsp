<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<<<<<<< HEAD
<%@ page import="model.beans.ShowsLocal"%>
<%@ page import="model.beans.Local"%>
<%
ArrayList<Local> locais = (ArrayList<Local>) request.getAttribute("locais");
=======
<%@ page import="model.beans.Local"%>
<%@ page import="model.beans.Show"%>
<%
ArrayList<Local> locais = (ArrayList<Local>) request.getAttribute("locais");

>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de Locais</title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h1>Lista de Locais</h1>
	<a href="FormControlLocais?operation=novo" class="Botao1">Novo</a>
<<<<<<< HEAD
		
		<form name="form" method="POST" action="ListarLocais">
			<div class="filtros">
			
					<div id="inputNome">
						<input type="text" name="nomeLugar" placeholder="Digite um lugar..." class="Caixa2">
=======
	
		<form name="form" method="POST" action="ListarLocais">
		<div class="filtros">
					<div id="inputNome">
						<input type="text" name="nomeLugar" placeholder="Digite o nome do lugar..." class="Caixa2">
>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a
						<input type="submit" value="Pesquisar" class="Botao1">
					</div>
				
			</div>
		</form>
<<<<<<< HEAD

	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>ONDE</th>
				<th>Nº de Shows</th>
=======
		
		<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>Nº de Show</th>
>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a
				<th>Capacidade</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
<<<<<<< HEAD
			for (Local lugar : locais) {
			%>
			<tr>
				<td><%=lugar.getIdLocal()%></td>
				<td><%=lugar.getNome()%></td>
				<td><%=lugar.getNumShows()%></td>
				<td><%=lugar.getCapacidade()%></td>
				<td>
					<a href="FormControlLocais?operation=editar&idLocal=<%=lugar.getIdLocal()%>" class="Botao1">Editar</a>
					<a href="javascript: confirmarLocal(<%=lugar.getIdLocal()%>)" class="Botao2">Excluir</a>
=======
			for (Local local : locais) {
			%>
			<tr>
				<td><%=local.getIdLocal()%></td>
				<td><%=local.getNome()%></td>
				<td><%=local.getNumShows() %></td>
				<td><%=local.getCapacidade()%></td>
				<td>
					<a href="FormControlShows?operation=editar&idShow=<%=local.getIdLocal()%>" class="Botao1">Editar</a>
					<a href="javascript: confirmarLocal(<%=local.getIdLocal()%>)" class="Botao2">Excluir</a>
>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a
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