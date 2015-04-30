package mr.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/maPageClassique")
public class ServletMaPageClassique extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletMaPageClassique() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("rangUtilisateur",request.getSession().getAttribute("rang"));
		request.setAttribute("pageGere",request.getSession().getAttribute("pageGere") );
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/maPageClassique.jsp");
		view.forward(request, response);
	}

}
