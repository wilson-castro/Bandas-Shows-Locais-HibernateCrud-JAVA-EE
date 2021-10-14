package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.ShowsLocal;
import model.dao.ShowsLocalDAO;


@WebServlet("/FormControlShows")
public class FormControlShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FormControlShows() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		if(operation.equals("novo")) {
			ShowsLocalDAO showDao = new ShowsLocalDAO();
			
        	ArrayList<ShowsLocal> listaShows = showDao.listarShowPorLocal();
			
			request.setAttribute("titulo", "Criar");
			request.setAttribute("selected", "-selecione-");
			request.setAttribute("dataDefault", "2020-10-13");
			request.setAttribute("shows", listaShows);
			
			RequestDispatcher rd = request.getRequestDispatcher("FormularioShows.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("ListarBandas");
		}
		
	}


}
