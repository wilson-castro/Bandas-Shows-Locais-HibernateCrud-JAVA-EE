package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Show;
import model.dao.LocalDAO;


@WebServlet(urlPatterns = { "/ControllerLocais", "/locais","/locais/delete","/locais/insert",
		"/locais/select","/locais/update" })
public class ControllerLocais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LocalDAO dao = new LocalDAO();
   
    public ControllerLocais() {
        super();
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/locais")) {
			locais(request, response);
		}else if (action.equals("/locais/insert")) {
			novoLocal(request, response);
		}else if(action.equals("/locais/update")) {
			editarLocal(request, response);
		}else if(action.equals("/locais/delete")) {
			removerLocal(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void locais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListarLocais");
		rd.forward(request, response);

	}
	
	protected void novoLocal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*Show show = new Show();
		
		String data =  request.getParameter("data");
		int idLocal = Integer.parseInt(request.getParameter("selectLocais"));
				
		show.setIdLocal(idLocal);
		show.setData(data);
		if (request.getParameterValues("List_BandaIDs") == null ) {
			dao.adicionarShow(show, null);
						
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_BandaIDs");
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			dao.adicionarShow(show, idsList);
		}
		
		response.sendRedirect("/projeto/shows");*/
	}
	
	protected void editarLocal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*Show show = new Show();
		
		
		String data = request.getParameter("data");
		int idLocal = Integer.parseInt(request.getParameter("selectLocais"));
		int idShow = Integer.parseInt(request.getParameter("idShow"));
		
		show.setIdShow(idShow);
		show.setIdLocal(idLocal);
		show.setData(data);
		
		if (request.getParameterValues("List_BandaIDs") == null) {
			dao.alterarShow(show,null);
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_BandaIDs");
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			dao.alterarShow(show,idsList);
			
		}*/
		
		response.sendRedirect("/projeto/shows");
	}
	
	protected void removerLocal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	int idShow = Integer.parseInt(request.getParameter("idShow"));
		Show show = new Show();
		show.setIdShow(idShow);
		
		dao.deletarShow(show);
			
		response.sendRedirect("/projeto/shows");*/

	}
 
}