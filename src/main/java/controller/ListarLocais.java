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
import model.dao.LocalDAO;


@WebServlet("/ListarLocais")
public class ListarLocais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListarLocais() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDAO dao = new LocalDAO();
	
		ArrayList<Local> locais = dao.listarLocais();
		 
		request.setAttribute("locais", locais);
		RequestDispatcher rd = request.getRequestDispatcher("TabelaLocais.jsp");
		rd.forward(request, response);
	}

}
