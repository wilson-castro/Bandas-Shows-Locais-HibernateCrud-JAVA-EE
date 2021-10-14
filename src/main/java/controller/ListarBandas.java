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
import model.dao.BandaDAO;
import model.enums.Genero;


@WebServlet("/ListarBandas")
public class ListarBandas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BandaDAO dao = new BandaDAO();
	
    public ListarBandas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Banda> bandas = dao.listarBandas();

		request.setAttribute("bandas", bandas);
		RequestDispatcher rd = request.getRequestDispatcher("TabelaBandas.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		
		if (request.getParameterValues("listGeneros") == null ) {
			Genero[] generos= new Genero[0];
			
			ArrayList<Banda> bandas = dao.listarBandasComFiltro(nome, generos);
			
			request.setAttribute("bandas", bandas);
			RequestDispatcher rd = request.getRequestDispatcher("TabelaBandas.jsp");
			rd.forward(request, response);
			
		}else {
			String[] checkboxlistGeneros = request.getParameterValues("listGeneros");
			int qtdGeneros = checkboxlistGeneros.length;
			
			Genero[] generos= new Genero[qtdGeneros];
						
			for (int i = 0; i < qtdGeneros; i++) {
				generos[i] = Genero.valueOf(checkboxlistGeneros[i]);
			}
			
			ArrayList<Banda> bandas = dao.listarBandasComFiltro(nome, generos);
			
			request.setAttribute("bandas", bandas);
			RequestDispatcher rd = request.getRequestDispatcher("TabelaBandas.jsp");
			rd.forward(request, response);
		}
		
	}


}
