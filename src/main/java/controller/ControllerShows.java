package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/ControllerShows", "/shows" })
public class ControllerShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControllerShows() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/shows")) {
			shows(request, response);
		}
	}
	
	protected void shows(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListarShows");
		rd.forward(request, response);

	}

}
