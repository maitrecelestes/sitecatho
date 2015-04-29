package mr.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.fabric.xmlrpc.base.Array;

import mr.dao.CategorieDao;
import mr.dao.UtilisateurDao;
import mr.daoImp.CategorieDaoImp;
import mr.daoImp.UtilisateurDaoImp;
import mr.entities.Categorie;
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
			List<Utilisateur> listeMessageUtilisateur=utilisateurdao.afficherListeUtilisateurNonArchive();
			request.setAttribute("listeMessageUtilisateur", listeMessageUtilisateur);
					
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationUtilisateur.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requete=request.getParameter("requete");
		String commentaire="";
		if (requete.equals("inscription")){
			String mail=request.getParameter("mail");
			String nom=request.getParameter("nom");
			String mdp=request.getParameter("mdp");
			String prenom=request.getParameter("prenom");
			String ecole=request.getParameter("ecole");
			String rang=request.getParameter("rang");
			String pageGere=request.getParameter("pageGere");
			
			
			
			
			//Verification si le mail existe
			List<Utilisateur> listeDeTousLesUtilisateur=utilisateurdao.afficherListeDeTousLesUtilisateur();
			boolean mailExiste=false;
			for (int i = 0; i < listeDeTousLesUtilisateur.size(); i++) {
				if(listeDeTousLesUtilisateur.get(i).getMail().equals(mail)){
					mailExiste=true;
				}
			}
			//recherche archive ou non
			List<Utilisateur> listeUtilisateurNonArchive=utilisateurdao.afficherListeUtilisateurNonArchive();
			boolean archive=true;
			if(mailExiste){
				for (int i = 0; i < listeUtilisateurNonArchive.size(); i++) {
					if(listeUtilisateurNonArchive.get(i).getMail().equals(mail)){
						archive=false;
					}
				}
			}
			
			
			
			if(mailExiste && archive){
				commentaire= "mail exite et est archivé donc modification++";
				//mail exite et est archivé donc modification++
				Utilisateur utilisateur=new Utilisateur(mail,mdp,nom,prenom,rang,ecole,pageGere);
				utilisateurdao.remplacementUtilisateur(utilisateur);
			}else if(mailExiste && !archive){
				commentaire="Mail exite mais non archivé = erreur";
				//Mail exite mais non archivé = erreur
			}else if(!mailExiste){
				commentaire="Pas de probleme et on ajoute le nouveau mail";
				//Pas de probleme et on ajoute le nouveau mail
				Utilisateur utilisateur=new Utilisateur(mail,mdp,nom,prenom,rang,ecole,pageGere);
				utilisateurdao.ajouterUtilisateur(utilisateur);
			}
		} else if (requete.equals("suppression")){
			String mail=request.getParameter("mail");
			utilisateurdao.supprimerUtilisateur(mail);
		} else if (requete.equals("modification")){
			String mail=request.getParameter("mail");
			String rang=request.getParameter("rang");
			String ecole=request.getParameter("ecole");
			String pageGere=request.getParameter("pageGere");
			utilisateurdao.modifierUtilisateur(mail,rang,ecole,pageGere);
		}else if (requete.equals("verificationSiMailNonArchive")){
			
			
		}
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationUtilisateur.jsp");
		view.forward(request, response);
	}
}
