package mr.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ContactDao;
import mr.daoImp.ContactDaoImp;
import mr.entities.Contact;

@WebServlet("/administrationContact")
public class ServletAdministrationContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private ContactDao contactDao = new ContactDaoImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("utilisateurConnecte") == null || "".equals(request.getSession().getAttribute("utilisateurConnecte"))){
			
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);
			
		} else {
			
			if (request.getSession().getAttribute("rang").equals("administrateur")){
				List<Contact> listeMessageContact=contactDao.listeMessageContact();
				request.setAttribute("listeMessageContact", listeMessageContact);
				
				RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationContact.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
				view.forward(request, response);
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString=request.getParameter("idMessage");
		int id=Integer.parseInt(idString);
		contactDao.supprimerContact(id);
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationContact.jsp");
		view.forward(request, response);
	}

}
