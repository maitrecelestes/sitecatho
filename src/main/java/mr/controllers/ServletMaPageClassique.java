package mr.controllers;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ArticleDao;
import mr.dao.PhotoEnteteDao;
import mr.daoImp.ArticleDaoImp;
import mr.daoImp.PhotoEnteteDaoImp;
import mr.entities.Article;
import mr.entities.PhotoEntete;

@WebServlet("/maPageClassique")
public class ServletMaPageClassique extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArticleDao articleDao = new ArticleDaoImp();
	private PhotoEnteteDao photoEnteteDao = new PhotoEnteteDaoImp();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("rangUtilisateur", request.getSession().getAttribute("rang"));
		request.setAttribute("pageGere",
				request.getSession().getAttribute("pageGere"));

		String page = "maPageClassique?nompage="
				+ request.getParameter("nompage");
		PhotoEntete lienPhotoEntete = photoEnteteDao.afficherPhotoEntete(page);
		request.setAttribute("lienPhotoEntete", lienPhotoEntete);

		String urlPage = request.getParameter("nompage");
		List<Article> maListeArticle = articleDao.listeArticlePage(urlPage);

		request.setAttribute("urlPage", urlPage);
		request.setAttribute("listeArticle", maListeArticle);

		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/maPageClassique.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String newLien = request.getParameter("newPhoto");
		String page = "maPageClassique?nompage="
				+ request.getParameter("nompage");
		String mail = (String) request.getSession().getAttribute(
				"utilisateurConnecte");
		photoEnteteDao.ajouterNouvellePhoto(new PhotoEntete(newLien, page),
				InetAddress.getLocalHost().getHostAddress(), mail);

		response.sendRedirect(page);
	}
}
