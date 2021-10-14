package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Show;
import model.beans.ShowsLocal;
import model.dao.ShowsLocalDAO;


@WebServlet("/ListarLocais")
public class ListarLocais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListarLocais() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowsLocalDAO showDao = new ShowsLocalDAO();
		
		/*
    	ArrayList<ShowsLocal> listaShows = showDao.listarShowPorLocal();
		
		ArrayList<Show> shows = dao.listarShows()
		*/

		//request.setAttribute("shows", listaShows);
		RequestDispatcher rd = request.getRequestDispatcher("TabelaLocais.jsp");
		rd.forward(request, response);
	}

}
