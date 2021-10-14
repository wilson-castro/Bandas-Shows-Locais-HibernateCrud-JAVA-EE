package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Show;
import model.dao.ShowDAO;


@WebServlet(urlPatterns = { "/ControllerShows", "/shows","/shows/delete" })
public class ControllerShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShowDAO dao = new ShowDAO();

    public ControllerShows() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/shows")) {
			shows(request, response);
		}else if(action.equals("/shows/delete")) {
			removerShow(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
	}
	
	protected void shows(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListarShows");
		rd.forward(request, response);

	}
	
	protected void removerShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idShow = Integer.parseInt(request.getParameter("idShow"));
		Show show = new Show();

		show.setIdShow(idShow);
		
		//dao.deletarShow(show);
		
		System.out.println("Deletando: "+ request.getParameter("idShow"));
	
		response.sendRedirect("/projeto/shows");

	}

}
