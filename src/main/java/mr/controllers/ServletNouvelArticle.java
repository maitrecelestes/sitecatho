package mr.controllers;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ArticleDao;
import mr.daoImp.ArticleDaoImp;
import mr.entities.Article;

@WebServlet("/nouvelarticle")
public class ServletNouvelArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("utilisateurConnecte") == null
				|| "".equals(request.getSession().getAttribute(
						"utilisateurConnecte"))) { //On test si l'utilisateur est connecté ou non. 

			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);

		} else { // L'UTILISATEUR EST BIEN CONNECTE AVEC UN COMPTE UTILISATEUR

			if (request.getSession().getAttribute("rang") //ON VERIFIE QU'IL EST ADMINISTRATEUR OU REDACTEUR DE LA PAGE
				//OU NOUS SOMMES
					.equals("administrateur")||(request.getSession().getAttribute("rang")
					.equals("redacteur")&&request.getSession().getAttribute("pageGere")
					.equals(request.getParameter("nompage")))) {
				RequestDispatcher view = request
						.getRequestDispatcher("/WEB-INF/ecrirearticle.jsp"); //SI OUI ON L'ENVOIE SUR LA BONNE PAGE
				view.forward(request, response);
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("/WEB-INF/accesinterdit.jsp"); //SINON ON LE REDIRIGE VERS UNE AUTRE PAGE
				view.forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String contenu = request.getParameter("contenu"); //ON RECUPERE LE CONTENU DE L'ARTICLE
		String titre = request.getParameter("titre"); // LE TITRE
		String mail = (String) request.getSession().getAttribute(
				"utilisateurConnecte"); //LE MAIL DU POSTEUR
		String page = request.getParameter("nompage");
		Boolean visiblePage = true; //ON INDIQUE PAR DEFAULT QUE L'ARTICLE EST VISIBLE
		
		Boolean articleDescription = false; //ON INDIQUE QUE CE N'EST PAS UN ARTICLE DE DESCRIPTION
		Article monArticle = new Article(contenu, titre, mail, page,
				visiblePage, articleDescription); //ON CREER L'OBJET ARTICLE
		String ipAddress = InetAddress.getLocalHost().getHostAddress(); //ON RECUPERE L'ADRESSE IP
		ArticleDao articleDao = new ArticleDaoImp();
		articleDao.ajouterArticle(monArticle, ipAddress); //ON APPELLE LA FONCTIO

		response.sendRedirect("maPageClassique?nompage=" + page); // ON REDIRIGE VERS LA PAGE D'OU VIENT 
																  // L'UTILISATEUR

	}

}
