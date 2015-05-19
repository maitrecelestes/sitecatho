package mr.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.MenuDao;
import mr.dao.UtilisateurDao;
import mr.daoImp.MenuDaoImpl;
import mr.daoImp.UtilisateurDaoImp;
import mr.entities.Menu;
import mr.entities.Utilisateur;

/*Page administration Utilisateur*/

@WebServlet("/administrationUtilisateur")
public class ServletAdministrationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurDao utilisateurdao = new UtilisateurDaoImp();
	private MenuDao menuDao = new MenuDaoImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*Recupère les informations et envoie les informations de la page administration Utilisateur*/
		
		if (request.getSession().getAttribute("utilisateurConnecte") == null
				|| "".equals(request.getSession().getAttribute(
						"utilisateurConnecte"))) { /*Verifie les connexions*/


			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);

		} else {
			if (request.getSession().getAttribute("rang")
					.equals("administrateur")) { /*Verifie les connexions*/
				List<Utilisateur> listeMessageUtilisateur = utilisateurdao
						.afficherListeUtilisateurNonArchive();
				request.setAttribute("listeMessageUtilisateur",
						listeMessageUtilisateur);
				request.setAttribute("rangUtilisateur", request.getSession().getAttribute("rang"));
				request.setAttribute("mail", request.getSession().getAttribute("utilisateurConnecte"));
				List<Menu> maListeMenu = menuDao.listerMenuPageAvecArticle();
				request.setAttribute("listeMenu", maListeMenu);

				RequestDispatcher view = request
						.getRequestDispatcher("/WEB-INF/administrationUtilisateur.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
				view.forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*Methode POST gérer la page administration utilisateur*/
		request.setAttribute("rangUtilisateur", request.getSession().getAttribute("rang"));
		String requete = request.getParameter("requete");
		if (requete.equals("inscription")) {
			
			//Recupère les informations 
			String mail = request.getParameter("mail");
			String nom = request.getParameter("nom");
			String mdp = request.getParameter("mdp");
			String prenom = request.getParameter("prenom");
			String ecole = request.getParameter("ecole");
			String rang = request.getParameter("rang");
			String pageGere = request.getParameter("pageGere");

			// Verification si le mail existe
			List<Utilisateur> listeDeTousLesUtilisateur = utilisateurdao
					.afficherListeDeTousLesUtilisateur();
			boolean mailExiste = false;
			for (int i = 0; i < listeDeTousLesUtilisateur.size(); i++) {
				if (listeDeTousLesUtilisateur.get(i).getMail().equals(mail)) {
					mailExiste = true;
				}
			}
			// recherche archive ou non
			List<Utilisateur> listeUtilisateurNonArchive = utilisateurdao
					.afficherListeUtilisateurNonArchive();
			boolean archive = true;
			if (mailExiste) {
				for (int i = 0; i < listeUtilisateurNonArchive.size(); i++) {
					if (listeUtilisateurNonArchive.get(i).getMail()
							.equals(mail)) {
						archive = false;
					}
				}
			}

			if (mailExiste && archive) {
				// mail exite et est archivé donc modification++
				Utilisateur utilisateur = new Utilisateur(mail, mdp, nom,
						prenom, rang, ecole, pageGere);
				utilisateurdao.remplacementUtilisateur(utilisateur);
			} else if (mailExiste && !archive) {
				// Mail exite mais non archivé = erreur
			} else if (!mailExiste) {
				// Pas de probleme et on ajoute le nouveau mail
				Utilisateur utilisateur = new Utilisateur(mail, mdp, nom,
						prenom, rang, ecole, pageGere);
				utilisateurdao.ajouterUtilisateur(utilisateur);
			}
		} else if (requete.equals("suppression")) {
			String mail = request.getParameter("mail");
			utilisateurdao.supprimerUtilisateur(mail);
		} else if (requete.equals("modification")) {
			String mail = request.getParameter("mail");
			String rang = request.getParameter("rang");
			String ecole = request.getParameter("ecole");
			String pageGere = request.getParameter("pageGere");
			String mdp=request.getParameter("mdp");
			try {
				utilisateurdao.modifierUtilisateur(mail, rang, ecole, pageGere,mdp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (requete.equals("verificationSiMailNonArchive")) {

		}

		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/administrationUtilisateur.jsp");
		view.forward(request, response);
	}
}
