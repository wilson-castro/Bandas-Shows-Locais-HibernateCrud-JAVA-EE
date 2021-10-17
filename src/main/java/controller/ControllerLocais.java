package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import model.beans.Local;
import model.dao.LocalDAO;
import model.dao.ShowDAO;
=======
import model.beans.Show;
import model.dao.LocalDAO;

>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a


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
<<<<<<< HEAD
		Local local = new Local();
		
		String nome =  request.getParameter("nome");
		int capacidade = Integer.parseInt(request.getParameter("capacidade"));
		
		local.setNome(nome);
		local.setCapacidade(capacidade);

		if (request.getParameterValues("List_ShowsIDs") == null ) {
			dao.adicionarLocal(local, null);
						
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_ShowsIDs");
=======
		/*Show show = new Show();
		
		String data =  request.getParameter("data");
		int idLocal = Integer.parseInt(request.getParameter("selectLocais"));
				
		show.setIdLocal(idLocal);
		show.setData(data);

		if (request.getParameterValues("List_BandaIDs") == null ) {
			dao.adicionarShow(show, null);
						
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_BandaIDs");
>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
<<<<<<< HEAD
			dao.adicionarLocal(local, idsList);
		}
		
		response.sendRedirect("/projeto/locais");
=======
			dao.adicionarShow(show, idsList);
		}
		
		response.sendRedirect("/projeto/shows");*/
>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a
	}
	
	protected void editarLocal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		Local local = new Local();
		
		String nome =  request.getParameter("nome");
		int capacidade = Integer.parseInt(request.getParameter("capacidade"));
		int idLocal = Integer.parseInt(request.getParameter("idLocal"));

		local.setIdLocal(idLocal);
		local.setNome(nome);
		local.setCapacidade(capacidade);
		
		if (request.getParameterValues("List_ShowsIDs") == null ) {
			dao.alterarLocal(local, null);
						
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_ShowsIDs");
=======
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
>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
<<<<<<< HEAD
			dao.alterarLocal(local, idsList);
		}
		
		response.sendRedirect("/projeto/locais");
=======
			dao.alterarShow(show,idsList);
			
		}*/
		
		response.sendRedirect("/projeto/shows");
>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a
	}
	
	protected void removerLocal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		int idLocal = Integer.parseInt(request.getParameter("idLocal"));
		
		Local local = new Local();
		local.setIdLocal(idLocal);
		
		dao.deletarLocal(local);
			
		response.sendRedirect("/projeto/locais");
=======
	/*	int idShow = Integer.parseInt(request.getParameter("idShow"));
		Show show = new Show();

		show.setIdShow(idShow);
		
		dao.deletarShow(show);
			
		response.sendRedirect("/projeto/shows");*/
>>>>>>> 0690f7234116e83e92b1cb685719bbc121fd397a

	}
 
}