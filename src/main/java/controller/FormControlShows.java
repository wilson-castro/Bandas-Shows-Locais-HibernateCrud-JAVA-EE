package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Banda;
import model.beans.Local;
import model.dao.BandaDAO;
import model.dao.LocalDAO;


@WebServlet("/FormControlShows")
public class FormControlShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FormControlShows() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		if(operation.equals("novo")) {
			
			LocalDAO localDao = new LocalDAO();
			BandaDAO bandaDao = new BandaDAO();
			
			ArrayList<Local> listaLocais = new ArrayList<Local>();
			listaLocais = localDao.listarLocais();
			
			ArrayList<Banda> listaBandas = new ArrayList<Banda>();
			listaBandas = bandaDao.listarBandas();
			
			request.setAttribute("titulo", "Criar");
			request.setAttribute("selected", "-selecione-");
			request.setAttribute("dataDefault", "2020-10-13");
			request.setAttribute("txtBotao", "Adicionar");
			request.setAttribute("locais", listaLocais);
			request.setAttribute("bandas", listaBandas);
			request.setAttribute("actionForm", "shows/insert");

			RequestDispatcher rd = request.getRequestDispatcher("FormularioShows.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("ListarBandas");
		}
		
	}


}
