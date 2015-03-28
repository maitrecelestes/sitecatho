package mr.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mr.dao.UtilisateurDao;
import mr.daoImp.UtilisateurDaoImp;
import mr.entities.Utilisateur;

@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UtilisateurDao utilisateurdao = new UtilisateurDaoImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("mail");
		String mdp=request.getParameter("mdp");
		System.out.println(request.getSession().getAttribute("utilisateurConnecte"));
		Utilisateur utilisateur= new Utilisateur(mail,mdp);
		boolean authentificationReussi= utilisateurdao.authentificationUtilisateur(utilisateur);
		if(authentificationReussi){
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateurConnecte", mail);
			
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/connexionreussi.jsp");
			view.forward(request, response);
			System.out.println(request.getSession().getAttribute("utilisateurConnecte"));
		} else {
			System.out.println("nope");
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/connexion.jsp");
			view.forward(request, response);
		}
		
	}

}
