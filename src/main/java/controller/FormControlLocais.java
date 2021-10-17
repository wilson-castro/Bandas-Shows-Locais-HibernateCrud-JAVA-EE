package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Local;
import model.beans.Show;
import model.beans.ShowsLocal;
import model.dao.LocalDAO;
import model.dao.ShowDAO;
import model.dao.ShowsLocalDAO;

@WebServlet("/FormControlLocais")
public class FormControlLocais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FormControlLocais() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		if(operation.equals("novo")) {
			
			ShowDAO ShowDao = new ShowDAO();
			
			ArrayList<Show> listaShow = ShowDao.listarShows();
			
			request.setAttribute("titulo", "Criar");
			request.setAttribute("txtBotao", "Adicionar");
			request.setAttribute("actionForm", "locais/insert");
			request.setAttribute("textoInputNome", "");
			request.setAttribute("textoInputCapacidade", "1");
			request.setAttribute("defaultInput", "Digite um nome...");
			request.setAttribute("shows", listaShow);
			
			RequestDispatcher rd = request.getRequestDispatcher("FormularioLocais.jsp");
			rd.forward(request, response);
		}else if(operation.equals("editar")){
			Local local = new Local();
			LocalDAO localDao = new LocalDAO();
			ShowDAO ShowDao = new ShowDAO();
			ShowsLocalDAO showsLocalDao = new ShowsLocalDAO();
			
			int idLocal = Integer.parseInt(request.getParameter("idLocal")); 	
			
			ArrayList<Show> listaShow = ShowDao.listarShows();
			ArrayList<ShowsLocal> listaShowLocal = showsLocalDao.listarShowPorLocalPorIdLocal(idLocal);
			
			local.setIdLocal(idLocal);
			localDao.selecionarLocal(local);
			
			request.setAttribute("titulo", "Editar");
			request.setAttribute("txtBotao", "Alterar");
			request.setAttribute("actionForm", "locais/update");
			request.setAttribute("textoInputNome", local.getNome());
			request.setAttribute("textoInputCapacidade", local.getCapacidade());
			request.setAttribute("defaultInput", "");
			request.setAttribute("shows", listaShow);
			request.setAttribute("listaShowsLocais", listaShowLocal);
			request.setAttribute("local", local);
			
			RequestDispatcher rd = request.getRequestDispatcher("FormularioLocais.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("ListarLocais");
		}
	}

}
