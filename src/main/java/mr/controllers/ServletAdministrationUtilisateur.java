package mr.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.UtilisateurDao;
import mr.daoImp.UtilisateurDaoImp;
import mr.entities.Utilisateur;



@WebServlet("/administrationUtilisateur")
public class ServletAdministrationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	private UtilisateurDao utilisateurdao = new UtilisateurDaoImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("utilisateurConnecte") == null || "".equals(request.getSession().getAttribute("utilisateurConnecte"))){
			
			//SI ON N'EST PAS CONNECTE, EMPECHE DE SE CONNECTER A L'ADMINISTRATION 
			
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);
			
		} else {
			List<Utilisateur> listeMessageUtilisateur=utilisateurdao.afficherListeUtilisateur();
			request.setAttribute("listeMessageUtilisateur", listeMessageUtilisateur);
			
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationUtilisateur.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requete=request.getParameter("requete");
		if (requete.equals("inscription")){
			String mail=request.getParameter("mail");
			String nom=request.getParameter("nom");
			String mdp=request.getParameter("mdp");
			String prenom=request.getParameter("prenom");
			String ecole=request.getParameter("ecole");
			String rang=request.getParameter("rang");
			String pageGere=request.getParameter("pageGere");
			
			
			Utilisateur utilisateur=new Utilisateur(mail,mdp,nom,prenom,rang,ecole,pageGere);
			utilisateurdao.ajouterUtilisateur(utilisateur);
			
		} else if (requete.equals("suppression")){
			String mail=request.getParameter("mail");
			utilisateurdao.supprimerUtilisateur(mail);
		} else if (requete.equals("modification")){
			String mail=request.getParameter("mail");
			String rang=request.getParameter("rang");
			utilisateurdao.modifierUtilisateur(mail,rang);
		}
		
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationUtilisateur.jsp");
		view.forward(request, response);
	}
}
