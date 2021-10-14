<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.ShowsLocal"%>
<%
ArrayList<ShowsLocal> listashows = (ArrayList<ShowsLocal>) request.getAttribute("shows");

String titulo = request.getAttribute("titulo").toString();
String selectedOption = request.getAttribute("selected").toString();
String dataDefault = request.getAttribute("dataDefault").toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=titulo%></title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h1><%=titulo %> show</h1>

	<form name="form" action="shows/insert">
		
		<div class="formComponentes">
			<input type=date name="data" min="2020-10-13" value="<%=dataDefault %>"
				class="Caixa2">
			<select id="selectGeneros" required name="selectGeneros">
				<option value="-selecione-">Selecione Genero</option>
				<% if(titulo.equals("Criar")){
					for(ShowsLocal show : listashows){ %>
					<option value=<%= show.getShow_Id() %> >ROCK</option>
					
					<input type="checkbox" id="<%=show.getShow_Id() %>" name="List_ShowsIDs" value=<%= show.getShow_Id() %>>
					<label for="<%= show.getShow_Id() %>">
					<strong>ID</strong>: <%= show.getShow_Id() %> -
					<strong>Lugar</strong>: <%= show.getLugar_nome() %> -
					<strong>Data</strong>: <%= show.getData_show() %> -
					<strong>Capacidade</strong>: <%= show.getCapacidade() %> 
					  </label><br>
				<%} 
				}%>
			</select>
					
			<h5>Shows</h5>
		</div>
		
		
		<input type="button" value="Criar" class="Botao1"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
	<script>
	//document.querySelector('#selectGeneros [value="<%=selectedOption %>"]').selected = true;

	</script>
</body>
</html>