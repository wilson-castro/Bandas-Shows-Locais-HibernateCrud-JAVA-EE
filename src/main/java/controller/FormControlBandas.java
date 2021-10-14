package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Banda;
import model.beans.ShowBanda;
import model.beans.ShowsLocal;
import model.dao.BandaDAO;
import model.dao.ShowsBandaDAO;
import model.dao.ShowsLocalDAO;

@WebServlet("/FormControlBandas")
public class FormControlBandas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FormControlBandas() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		if(operation.equals("novo")) {
			ShowsLocalDAO showDao = new ShowsLocalDAO();
			
        	ArrayList<ShowsLocal> listaShows = showDao.listarShowPorLocal();

			
			request.setAttribute("titulo", "Criar");
			request.setAttribute("defaultInput", "Digite um nome...");
			request.setAttribute("selected", "-selecione-");
			request.setAttribute("txtBotao", "Adicionar");
			request.setAttribute("textoInputNome", "");
			request.setAttribute("actionForm", "bandas/insert");
			request.setAttribute("shows", listaShows);
			
			RequestDispatcher rd = request.getRequestDispatcher("FormularioBandas.jsp");
			rd.forward(request, response);
		}else if(operation.equals("editar")){
			Banda banda = new Banda();
			BandaDAO dao = new BandaDAO();
			
			int idBanda = Integer.parseInt(request.getParameter("idBanda"));
			
			banda.setIdBanda(idBanda);
			dao.selecionarBanda(banda);
			
			ShowsLocalDAO showDao = new ShowsLocalDAO();
			ShowsBandaDAO showbandaDao = new ShowsBandaDAO();
			
			ShowBanda sb = new ShowBanda();
			sb.setId_banda(idBanda);
			
        	ArrayList<ShowsLocal> listaShows = showDao.listarShowPorLocal();
        	ArrayList<ShowBanda> listaShowBanda = showbandaDao.selecionarShowsPorBanda(sb);
			
			request.setAttribute("titulo", "Editar");
			request.setAttribute("defaultInput", "");
			request.setAttribute("selected", banda.getGenero().toString());
			request.setAttribute("txtBotao", "Alterar");
			request.setAttribute("textoInputNome", banda.getNome());
			request.setAttribute("shows", listaShows);
			request.setAttribute("Banda", banda);			
			request.setAttribute("ShowsDaBanda", listaShowBanda);
			request.setAttribute("actionForm", "bandas/update");
			
			RequestDispatcher rd = request.getRequestDispatcher("FormularioBandas.jsp");
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("ListarBandas");
		}
		
	}


}
