<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.ShowsLocal"%>
<%
ArrayList<ShowsLocal> listashows = (ArrayList<ShowsLocal>) request.getAttribute("shows");

String titulo = request.getAttribute("titulo").toString();
String placeHolderInput = request.getAttribute("defaultInput").toString();
String selectedOption = request.getAttribute("selected").toString();
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

	<form name="frmContato" action="insert">
		
		<div class="formComponentes">
			<input type="text" name="nome" placeholder="<%=placeHolderInput%>"
				class="Caixa2">
			<select id="selectGeneros" name="selectGeneros">
				<option value="-selecione-">Selecione Genero</option>
				<option value="ROCK" >ROCK</option>
				<option value="FORRO">FORRÓ</option>
				<option value=AXE>AXÉ</option>
			</select>
			
			<div class="group-checkbox">
				<% if(titulo.equals("Criar")){
					for(ShowsLocal show : listashows){ %>
					<input type="checkbox" id="<%= %>" name="ROCK" value="ROCK">
					<label for="vehicle1"> ROCK</label><br>
				<%} 
				}%>
					
			</div>
		</div>
		
		
		<input type="button" value="Adicionar" class="Botao1"
			onclick="validar()">
	</form>
	<script src="scripts/setarInputs.js"></script>
	<script>
	document.querySelector('#selectGeneros [value="<%=selectedOption %>"]').selected = true;

	</script>
</body>
</html>