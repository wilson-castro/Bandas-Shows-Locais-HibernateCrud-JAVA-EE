package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormControlBandas")
public class FormControlBandas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FormControlBandas() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		if(operation.equals("novo")) {
			request.setAttribute("titulo", "Criar");
			request.setAttribute("defaultInput", "Digite um nome...");
			request.setAttribute("selected", "-selecione-");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("FormularioBandas.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("ListarBandas");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
