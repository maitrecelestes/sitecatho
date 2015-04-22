package mr.controllers;

import java.io.IOException;
<<<<<<< HEAD
import java.net.InetAddress;
=======
>>>>>>> e745e85681bb2e4e10c6ccc1828ac523916b54b3

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import mr.dao.ContactDao;
import mr.daoImp.ContactDaoImp;
import mr.entities.Contact;

@WebServlet("/galerie")
public class ServletGalerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletGalerie() {
        super();
    }
=======
@WebServlet("/galerie")
public class ServletGalerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
>>>>>>> e745e85681bb2e4e10c6ccc1828ac523916b54b3

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/galerie.jsp");
		view.forward(request, response);
	}

<<<<<<< HEAD
=======
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

>>>>>>> e745e85681bb2e4e10c6ccc1828ac523916b54b3
}
