<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.beans.ShowsLocal"%>
<%@ page import="model.beans.ShowBanda"%>
<%@ page import="model.beans.Banda"%>

<%
ArrayList<ShowsLocal> listashows = (ArrayList<ShowsLocal>) request.getAttribute("shows");
ArrayList<ShowBanda> listaShowBanda = new ArrayList<ShowBanda>();
ArrayList<Integer> idsIguaisShows = new ArrayList<>();

String titulo = request.getAttribute("titulo").toString();
String placeHolderInput = request.getAttribute("defaultInput").toString();
String selectedOption = request.getAttribute("selected").toString();
String textoBotao = request.getAttribute("txtBotao").toString();
String textoInputNome = request.getAttribute("textoInputNome").toString();
String actionForm  = request.getAttribute("actionForm").toString();
Banda banda = (Banda) request.getAttribute("Banda");

if(titulo.equals("Editar")){
	listaShowBanda = (ArrayList<ShowBanda>) request.getAttribute("ShowsDaBanda");
}

for(ShowsLocal sl : listashows){	
		
	for(ShowBanda sb :listaShowBanda){
		System.out.println(sb.getId_show());

		if(sb.getId_show()==sl.getShow_Id() && !idsIguaisShows.contains(sb.getId_show())){
			idsIguaisShows.add(sb.getId_show());
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
	<h1><%=titulo %> banda</h1>

	<form name="form" action="<%=actionForm%>">
		
		<div class="formComponentes">
			
			<% if(titulo.equals("Editar")){ %>
				<div class="ID-group">
					<label for="Caixa3"> ID </label>
					<input type="text" name="idBanda" readOnly id="Caixa3"
						value="<% out.print(banda.getIdBanda()); %>">
				</div>

			<% }%>
			<input type="text" name="nome" value="<%=textoInputNome %>" required placeholder="<%=placeHolderInput%>"
				class="Caixa2">
			<select id="selectGeneros" required name="selectGeneros">
				<option value="-selecione-">Selecione Genero</option>
				<option value="ROCK" >ROCK</option>
				<option value="FORRO">FORRÓ</option>
				<option value=AXE>AXÉ</option>
			</select>
					
			<h5>Shows</h5>
			<div class="group-checkbox">
				<% for(ShowsLocal show : listashows){ %>
					<input type="checkbox"
					<%
						if(idsIguaisShows.contains(show.getShow_Id())){
							out.print("checked");
						}
					%>
					 id="<%=show.getShow_Id() %>"
					 name="List_ShowsIDs" value=<%= show.getShow_Id() %>
					>
					<label for="<%= show.getShow_Id() %>">
					<strong>ID</strong>: <%= show.getShow_Id() %> -
					<strong>Lugar</strong>: <%= show.getLugar_nome() %> -
					<strong>Data</strong>: <%= show.getData_show() %> -
					<strong>Capacidade</strong>: <%= show.getCapacidade() %> 
					  </label><br>
				<%}%>
					
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