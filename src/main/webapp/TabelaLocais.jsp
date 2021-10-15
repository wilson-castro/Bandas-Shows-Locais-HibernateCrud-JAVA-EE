<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.Local"%>
<%@ page import="model.beans.Show"%>
<%
ArrayList<Local> locais = (ArrayList<Local>) request.getAttribute("locais");

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
	
		<form name="form" method="POST" action="ListarLocais">
		<div class="filtros">
					<div id="inputNome">
						<input type="text" name="nomeLugar" placeholder="Digite o nome do lugar..." class="Caixa2">
						<input type="submit" value="Pesquisar" class="Botao1">
					</div>
				
			</div>
		</form>
		
		<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>Nº de Show</th>
				<th>Capacidade</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
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