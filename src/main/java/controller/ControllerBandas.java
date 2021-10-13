package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Banda;
import model.dao.BandaDAO;
import model.enums.Genero;


@WebServlet(urlPatterns = { "/ControllerBandas", "/bandas", "/bandas/insert" })
public class ControllerBandas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BandaDAO dao = new BandaDAO();
	Banda banda = new Banda();
	
	
	public ControllerBandas() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/bandas")) {
			bandas(request, response);
		}else if (action.equals("/bandas/insert")) {
			//response.getWriter().append("Served at: ").append(request.getContextPath());

			novaBanda(request, response);
		} /*else
			 * if (action.equals("/select")) { listarContato(request, response); } else if
			 * (action.equals("/update")) { editarContato(request, response); } else if
			 * (action.equals("/delete")) { removerContato(request, response); }
			 */
		else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void bandas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListarBandas");
		rd.forward(request, response);

	}
	
	protected void novaBanda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String generoString = request.getParameter("selectGeneros");
    	Genero genero = Genero.valueOf(generoString);
		
    	banda.setGenero(genero);
		banda.setNome(nome);
				
		if (request.getParameterValues("List_ShowsIDs") == null ) {
			dao.adicionarBanda(banda, null);
			
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_ShowsIDs");
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			dao.adicionarBanda(banda, idsList);
		}
		
		response.sendRedirect("/projeto/bandas");
	}
}
