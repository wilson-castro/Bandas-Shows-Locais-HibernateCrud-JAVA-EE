<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.ShowBanda"%>
<%@ page import="model.beans.ShowsLocal"%>
<%@ page import="model.beans.Local"%>
<%@ page import="model.beans.Banda"%>
<%@ page import="model.beans.Show"%>

<%
ArrayList<ShowBanda> listaShowBanda = new ArrayList<ShowBanda>();
ArrayList<Local> listaLocais = (ArrayList) request.getAttribute("locais");
ArrayList<Banda> listaBandas = (ArrayList) request.getAttribute("bandas");
ArrayList<Integer> idsIguaisShows = new ArrayList<>();
String titulo = request.getAttribute("titulo").toString();
String selectedOption = request.getAttribute("selected").toString();
String dataDefault = request.getAttribute("dataDefault").toString();
String actionForm  = request.getAttribute("actionForm").toString();
String textoBotao = request.getAttribute("txtBotao").toString();
Show show = (Show) request.getAttribute("show");


if(titulo.equals("Editar")){
	listaShowBanda = (ArrayList<ShowBanda>) request.getAttribute("ShowsDaBanda");
}
for(Banda sl : listaBandas){	
		
	for(ShowBanda sb :listaShowBanda){
		
		System.out.println(sb.getId_banda());
		
		if(sb.getId_banda()==sl.getIdBanda() && !idsIguaisShows.contains(sb.getId_banda())){
			idsIguaisShows.add(sb.getId_banda());
		}
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
	<h1><%=titulo %> show</h1>

	<form name="form" action="<%=actionForm%>">
		
		<div class="formComponentes">
			<div>
				<% if(titulo.equals("Editar")){ %>
					<label for="Caixa3"> ID </label>
					<input type="text" name="idBanda" readOnly id="Caixa3"
						value="<% out.print(show.getIdShow()); %>">
				<% }%>
			</div>
					
			<div class="ID-group">
					<input type=date id="data" name="data" min="<%=dataDefault %>" value="<%=dataDefault %>"
						class="Caixa2">
			</div>
					
			<select id="selectLocais" required name="selectLocais">
				<option value="-selecione-">Selecione o Local</option>
				<% for(Local local : listaLocais) { %>
					<option value="<%=local.getIdLocal() %>" >
					<%=local.getIdLocal() %> - 
					<%=local.getNome() %> - 
					<%=local.getCapacidade() %></option>
				<%} %>
			</select>
			
			<h5>Bandas</h5>
			<div class="group-checkbox">
				<% for(Banda banda : listaBandas){ %>
					<input type="checkbox"
					 id="<%=banda.getIdBanda() %>"
					 <%
						if(idsIguaisShows.contains(banda.getIdBanda())){
							out.print("checked");
						}
					%>
					 name="List_BandaIDs" value=<%= banda.getIdBanda() %>
					>
					<label for="<%= banda.getIdBanda() %>">
						<strong>ID</strong>: <%= banda.getIdBanda() %> -
						<strong>Nome</strong>: <%= banda.getNome() %> -
						<strong>Genero</strong>: <%= banda.getGenero().getDescricao() %>
   					</label><br>
				<%}%>
					
			</div>
			
		</div>
		
		
		<input type="button" value="<%=textoBotao %>" class="Botao1"
			onclick="validarShow()">
	</form>
	<script src="scripts/validador.js"></script>
	<script>
	document.querySelector('#selectLocais [value="<%=selectedOption %>"]').selected = true;
	</script>
</body>
</html>