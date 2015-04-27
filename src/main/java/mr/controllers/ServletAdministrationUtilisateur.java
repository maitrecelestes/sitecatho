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
			List<Utilisateur> listeMessageUtilisateur=utilisateurdao.afficherListeUtilisateurNonArchive();
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
				//mail exite et est archivé donc modification++
				System.out.println("mail exite et est archivé donc modification++");
			}else if(mailExiste && !archive){
				//Mail exite mais non archivé = erreur
				System.out.println("Mail exite mais non archivé = erreur");
			}else if(!mailExiste){
				//Pas de probleme et on ajoute le nouveau mail
				System.out.println("Pas de probleme et on ajoute le nouveau mail");
				Utilisateur utilisateur=new Utilisateur(mail,mdp,nom,prenom,rang,ecole,pageGere);
				utilisateurdao.ajouterUtilisateur(utilisateur);
			}
			
			
			
			/*String mail=(String) request.getSession().getAttribute("utilisateurConnecte");
			String nom=(String) request.getSession().getAttribute("nom");
			String prenom=(String) request.getSession().getAttribute("prenom");
			String rang=(String) request.getSession().getAttribute("rang");
			String pageGere=(String) request.getSession().getAttribute("pageGere");
			ArrayList<String> informationUtilisateur=new ArrayList<String>();
			informationUtilisateur.add(mail);
			informationUtilisateur.add(nom);
			informationUtilisateur.add(prenom);
			informationUtilisateur.add(rang);
			informationUtilisateur.add(pageGere);
			
			Gson gson = new Gson();
		    String json = gson.toJson(informationUtilisateur);
			
		    PrintWriter out = response.getWriter();
			out.append(json);*/
			
			
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
