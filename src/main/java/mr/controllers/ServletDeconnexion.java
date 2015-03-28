package mr.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deconnexion")
public class ServletDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public ServletDeconnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.invalidate();
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/deconnexion.jsp");
		view.forward(request, response);
	}


}