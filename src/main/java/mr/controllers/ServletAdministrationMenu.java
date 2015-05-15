package mr.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ArticleDao;
import mr.dao.MenuDao;
import mr.daoImp.ArticleDaoImp;
import mr.daoImp.MenuDaoImpl;
import mr.entities.Menu;

/*Page administration Menu*/

@WebServlet("/administrationMenu")
public class ServletAdministrationMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MenuDao menuDao = new MenuDaoImpl();
	private ArticleDao articleDao = new ArticleDaoImp();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*Recupère les informations et envoie les informations de la page administration Menu*/
		
		if (request.getSession().getAttribute("utilisateurConnecte") == null
				|| "".equals(request.getSession().getAttribute(
						"utilisateurConnecte"))) {/*Verifie les connexions*/

			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);

		} else {

			if (request.getSession().getAttribute("rang")
					.equals("administrateur")) {/*Verifie les connexions*/
				List<Menu> maListeMenu = menuDao.listerMenu();
				request.setAttribute("listeMenu", maListeMenu);
				request.setAttribute("rangUtilisateur", request.getSession().getAttribute("rang"));
				
				RequestDispatcher view = request
						.getRequestDispatcher("/WEB-INF/administrationMenu.jsp");
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
		
		/*Methode POST appelé pour ajouter, modifier, supprimer un menu*/
		request.setAttribute("rangUtilisateur", request.getSession().getAttribute("rang"));
		String maFonction = request.getParameter("maFonction");
		if (maFonction.equals("fonctionAjout")) {
			// Ajout d'un menu
			String nompage = request.getParameter("nompage");
			String nompageprecedente = request
					.getParameter("nompageprecedente");
			int nbPage = 0;
			if (nompageprecedente.equals("page_0")) {
				nbPage = 1000;
			} else {
				String lenompageprecedente = "";
				if (nompageprecedente.length() == 18) {
					lenompageprecedente = "" + nompageprecedente.charAt(17);
				} else if (nompageprecedente.length() == 19) {
					lenompageprecedente = "" + nompageprecedente.charAt(17)
							+ nompageprecedente.charAt(18);
				} else if (nompageprecedente.length() == 20) {
					lenompageprecedente = "" + nompageprecedente.charAt(17)
							+ nompageprecedente.charAt(18)
							+ nompageprecedente.charAt(19);
				}
				nbPage = Integer.parseInt(lenompageprecedente);
			}
			String rang = request.getParameter("rang");
			int leRang = 1;
			if (rang.equals("true")) {
				leRang = 0;
			}
			String visibilite = request.getParameter("visibilite");

			Menu nouveauMenu = new Menu(0, nompage, leRang,
					Boolean.parseBoolean(visibilite));
			menuDao.ajouterNouveauMenu(nbPage, nouveauMenu);

		} else if (maFonction.equals("fonctionModification")) {
			// Modification d'un menu

			String idModif = request.getParameter("idModif");
			String nompageModif = request.getParameter("nompageModif");
			String idpageprecedenteModif = request
					.getParameter("nompageprecedenteModif");
			int nbPageModif = 0;
			if (idpageprecedenteModif.equals("page_0")) {
				nbPageModif = 1000;
			} else {
				nbPageModif = Integer.parseInt(idpageprecedenteModif);
			}
			String rang = request.getParameter("rangModif");
			int leRangModif = 1;
			if (rang.equals("true")) {
				leRangModif = 0;
			}
			String visibiliteModif = request.getParameter("visibiliteModif");

			if (nompageModif.length() > 0) {
				Menu monMenu = menuDao.rechercheMenu(Integer.parseInt(idModif));
				articleDao.modifierPageArticle(monMenu.getNompage(),
						nompageModif);

				Menu nouveauMenuModif = new Menu(Integer.parseInt(idModif),
						nompageModif, leRangModif,
						Boolean.parseBoolean(visibiliteModif));
				menuDao.modifierMenu(nbPageModif, nouveauMenuModif);
			}

		} else if (maFonction.equals("fonctionSuppression")) {
			// Suppression d'un menu
			
			String idString = request.getParameter("idpage");
			int id = Integer.parseInt(idString);
			menuDao.supprimerLigneDansMenu(id);
		}

	}

}
