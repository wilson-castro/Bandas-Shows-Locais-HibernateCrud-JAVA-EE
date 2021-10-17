<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="model.beans.ShowBanda"%>
<%@ page import="model.beans.ShowsLocal"%>
<%@ page import="model.beans.Local"%>
<%@ page import="model.beans.Show"%>

<%
ArrayList<Show> listaShow= new ArrayList<Show>();
ArrayList<ShowsLocal> listaShowsLocais = new ArrayList<ShowsLocal>();
ArrayList<Integer> idsIguaisShows = new ArrayList<>();
listaShow = (ArrayList<Show>) request.getAttribute("shows");
																															
String titulo = request.getAttribute("titulo").toString();
String actionForm  = request.getAttribute("actionForm").toString();
String textoBotao = request.getAttribute("txtBotao").toString();
String textoInputNome = request.getAttribute("textoInputNome").toString();
String textoInputCapacidade = request.getAttribute("textoInputCapacidade").toString();
String placeHolderInput = request.getAttribute("defaultInput").toString();
Local local = (Local) request.getAttribute("local");

SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
String dataFormat = "";

if(titulo.equals("Editar")){
	listaShowsLocais = (ArrayList<ShowsLocal>) request.getAttribute("listaShowsLocais");
}

	for(Show show: listaShow){
		if(local.getIdLocal()==show.getIdLocal() && !idsIguaisShows.contains(show.getIdShow())){
			idsIguaisShows.add(show.getIdShow());
		}
	
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=titulo%></title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h1><%=titulo %> Local</h1>

	<form name="form" action="<%=actionForm%>">
		
		<div class="formComponentes">
			<div>
				<% if(titulo.equals("Editar")){ %>
					<label for="Caixa3"> ID </label>
					<input type="text" name="idLocal" readOnly id="Caixa3"
						value="<% out.print(local.getIdLocal()); %>">
				<% }%>
			</div>
				<input type="text" name="nome" placeholder="<%=placeHolderInput %>"
					value="<%=textoInputNome %>" class="Caixa2">
				<input type="number" id="capacidade" name="capacidade" value="<%=textoInputCapacidade %>"
				 min=1 class="Caixa2">
				
			<h5>Shows</h5>
			<div class="group-checkbox">
				<% for(Show show : listaShow){ %>
					<input type="checkbox"
						<%
						if(idsIguaisShows.contains(show.getIdShow())){
							out.print("checked");
						}
					%>
					 id="<%=show.getIdShow()%>"
					 name="List_ShowsIDs" value=<%= show.getIdShow()%>
					>
					<label for="<%= show.getIdShow() %>">
						<strong>ID</strong>: <%= show.getIdShow() %> -
						<strong>Data</strong>: <%
						dataFormat = formatDate.format(show.getData().getTime());
						out.print(dataFormat);
						%> -
						<strong>Nº Bandas</strong>: <%= show.getNumBandas() %>
					 </label><br>
				<%}%>
			</div>
			
		</div>
		
		
		<input type="button" value="<%=textoBotao %>" class="Botao1"
			onclick="validarLocal()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>