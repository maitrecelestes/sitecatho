package mr.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	 public ServletAdministrationUtilisateur() { // TEST POUR RECUPERER LES INFO DE SESSION
	        super();
	 }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Utilisateur> listeMessageUtilisateur=utilisateurdao.afficherListeUtilisateur();
		request.setAttribute("listeMessageUtilisateur", listeMessageUtilisateur);
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationUtilisateur.jsp");
		view.forward(request, response);
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
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateNaissance=request.getParameter("dateDeNaissance");
			Date dateNaissanceDate;
			try {
				dateNaissanceDate = (Date) formatter.parse(dateNaissance);
				java.sql.Date datenaissanceSQL= new java.sql.Date(dateNaissanceDate.getTime());
				Utilisateur utilisateur=new Utilisateur(mail,mdp,nom,prenom,datenaissanceSQL,rang,ecole);
				utilisateurdao.ajouterUtilisateur(utilisateur);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
