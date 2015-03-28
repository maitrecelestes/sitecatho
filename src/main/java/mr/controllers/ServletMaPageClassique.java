package mr.controllers;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ContactDao;
import mr.daoImp.ContactDaoImp;
import mr.entities.Contact;

@WebServlet("/maPageClassique")
public class ServletMaPageClassique extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletMaPageClassique() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/maPageClassique.jsp");
		view.forward(request, response);
	}

}
