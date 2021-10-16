<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.ShowsLocal"%>
<%@ page import="model.beans.Local"%>
<%
ArrayList<Local> locais = (ArrayList<Local>) request.getAttribute("locais");
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
		
		<form name="form" method="POST" action="ListarLocais">
			<div class="filtros">
			
					<div id="inputNome">
						<input type="text" name="nomeLugar" placeholder="Digite um lugar..." class="Caixa2">
						<input type="submit" value="Pesquisar" class="Botao1">
					</div>
				
			</div>
		</form>

	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>ONDE</th>
				<th>Nº de Shows</th>
				<th>Capacidade</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Local lugar : locais) {
			%>
			<tr>
				<td><%=lugar.getIdLocal()%></td>
				<td><%=lugar.getNome()%></td>
				<td><%=lugar.getNumShows()%></td>
				<td><%=lugar.getCapacidade()%></td>
				<td>
					<a href="FormControlLocais?operation=editar&idLocal=<%=lugar.getIdLocal()%>" class="Botao1">Editar</a>
					<a href="javascript: confirmarShow(<%=lugar.getIdLocal()%>)" class="Botao2">Excluir</a>
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