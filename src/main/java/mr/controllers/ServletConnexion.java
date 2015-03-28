package mr.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

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
		
		Utilisateur utilisateur= new Utilisateur(mail,mdp);
		boolean authentificationReussi= utilisateurdao.authentificationUtilisateur(utilisateur);
		if(authentificationReussi){
			Utilisateur utilisateurConnecte= utilisateurdao.afficherUtilisateur(mail);
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateurConnecte", mail);
			session.setAttribute("rang", utilisateurConnecte.getRang());
			session.setAttribute("pageGere", utilisateurConnecte.getPageGere());
			session.setAttribute("nom", utilisateurConnecte.getNom());
			session.setAttribute("prenom", utilisateurConnecte.getPrenom());
			
			Gson gson = new Gson();
		    String json = gson.toJson(authentificationReussi);
			
		    PrintWriter out = response.getWriter();
			out.append(json);
		}
		

	}
}