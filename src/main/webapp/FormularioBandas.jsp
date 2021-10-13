<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.ShowsLocal"%>
<%
ArrayList<ShowsLocal> listashows = (ArrayList<ShowsLocal>) request.getAttribute("shows");

String titulo = request.getAttribute("titulo").toString();
String placeHolderInput = request.getAttribute("defaultInput").toString();
String selectedOption = request.getAttribute("selected").toString();
String textoBotao = request.getAttribute("txtBotao").toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=titulo%></title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h1><%=titulo %> banda</h1>

	<form name="frmContato" action="bandas/insert">
		
		<div class="formComponentes">
			<input type="text" name="nome" required placeholder="<%=placeHolderInput%>"
				class="Caixa2">
			<select id="selectGeneros" required name="selectGeneros">
				<option value="-selecione-">Selecione Genero</option>
				<option value="ROCK" >ROCK</option>
				<option value="FORRO">FORRÓ</option>
				<option value=AXE>AXÉ</option>
			</select>
					
			<h5>Shows</h5>
			<div class="group-checkbox">
				<% if(titulo.equals("Criar")){
					for(ShowsLocal show : listashows){ %>
					<input type="checkbox" id="<%=show.getShow_Id() %>" name="List_ShowsIDs" value=<%= show.getShow_Id() %>>
					<label for="<%= show.getShow_Id() %>">
					<strong>ID</strong>: <%= show.getShow_Id() %> -
					<strong>Lugar</strong>: <%= show.getLugar_nome() %> -
					<strong>Data</strong>: <%= show.getData_show() %> -
					<strong>Capacidade</strong>: <%= show.getCapacidade() %> 
					  </label><br>
				<%} 
				}%>
					
			</div>
		</div>
		
		
		<input type="button" value="<%=textoBotao %>" class="Botao1"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
	<script>
	document.querySelector('#selectGeneros [value="<%=selectedOption %>"]').selected = true;

	</script>
</body>
</html>