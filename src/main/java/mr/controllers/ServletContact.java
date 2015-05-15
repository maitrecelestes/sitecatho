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

@WebServlet("/contact")
public class ServletContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContact() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/contact.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String objet = request.getParameter("objet");
		String contenu = request.getParameter("contenu");
		String mail = request.getParameter("mail");
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		Contact newContact = new Contact(nom, prenom, mail, objet, contenu,
				ipAddress);
		ContactDao contactDao = new ContactDaoImp();
		contactDao.ajouterContact(newContact);

		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/contact.jsp");
		view.forward(request, response);

	}

}
