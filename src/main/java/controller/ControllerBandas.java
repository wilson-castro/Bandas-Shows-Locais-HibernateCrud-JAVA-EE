package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/ControllerBandas", "/bandas" })
public class ControllerBandas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerBandas() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/bandas")) {
			bandas(request, response);
		} /*
			 * else if (action.equals("/insert")) { novoContato(request, response); } else
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

}
