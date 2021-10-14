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
import model.beans.Show;
import model.beans.ShowsLocal;
import model.dao.ShowDAO;
import model.dao.ShowsLocalDAO;
import model.enums.Genero;


@WebServlet("/ListarShows")
public class ListarShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ShowDAO dao = new ShowDAO();
   
    public ListarShows() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowsLocalDAO showDao = new ShowsLocalDAO();
		
    	ArrayList<ShowsLocal> listaShows = showDao.listarShowPorLocal();
		
		request.setAttribute("shows", listaShows);
		RequestDispatcher rd = request.getRequestDispatcher("TabelaShows.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeLugar");
		
		ShowsLocalDAO showDao = new ShowsLocalDAO();
		
    	ArrayList<ShowsLocal> listaShows = showDao.listarShowPorLocaComFiltrol(nome);
		
		request.setAttribute("shows", listaShows);
		RequestDispatcher rd = request.getRequestDispatcher("TabelaShows.jsp");
		rd.forward(request, response);
		
	}

}
