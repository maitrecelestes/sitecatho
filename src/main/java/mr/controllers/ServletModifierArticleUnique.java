package mr.controllers;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ArticleUniqueDao;
import mr.daoImp.ArticleUniqueDaoImp;
import mr.entities.ArticleUnique;

@WebServlet("/modifierarticleunique")
public class ServletModifierArticleUnique extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("utilisateurConnecte") == null
				|| "".equals(request.getSession().getAttribute(
						"utilisateurConnecte"))) {

			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);

		} else {

			if (request.getSession().getAttribute("rang")
					.equals("administrateur")) {

				RequestDispatcher view = request
						.getRequestDispatcher("/WEB-INF/modifierarticleUnique.jsp");
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

		String contenu = request.getParameter("contenu");
		String titre = request.getParameter("titre");
		String mail = (String) request.getSession().getAttribute(
				"utilisateurConnecte");
		String nompage = request.getParameter("nompage");

		ArticleUnique monNouvelArticleUnique = new ArticleUnique(nompage, mail,
				contenu, titre);
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		ArticleUniqueDao articleUniqueDao = new ArticleUniqueDaoImp();
		articleUniqueDao.modifierArticle(nompage, monNouvelArticleUnique,
				ipAddress);

		response.sendRedirect("accueil");

	}

}
