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
			request.setAttribute("shows", listaShows);
			
			RequestDispatcher rd = request.getRequestDispatcher("FormularioBandas.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("ListarBandas");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
