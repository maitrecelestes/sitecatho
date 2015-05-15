package mr.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.CategorieDao;
import mr.dao.ImageDao;
import mr.daoImp.CategorieDaoImp;
import mr.daoImp.ImageDaoImp;
import mr.entities.Categorie;
import mr.entities.Image;

@WebServlet("/categorieGalerie")
public class ServletCategorieGalerie extends HttpServlet {

	private static final long serialVersionUID = -7041794190655964426L;
	private ImageDao imageDao = new ImageDaoImp();
	private CategorieDao categorieDao = new CategorieDaoImp();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idCategorieString = request.getParameter("idpage");
		int idCategorie = Integer.parseInt(idCategorieString);
		Categorie maCategorie = categorieDao.afficherUneCategorie(idCategorie);
		List<Image> listeImage = imageDao.listeImageCategorie(idCategorie);

		request.setAttribute("rangUtilisateur", request.getSession()
				.getAttribute("rang"));
		request.setAttribute("listeImage", listeImage);
		request.setAttribute("maCategorie", maCategorie);

		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/categorieGalerie.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requete = request.getParameter("action");
		if (requete == null) {
			requete = "null";
		}
		if (requete.equals("suppressionImage")) {
			String idImageString = request.getParameter("idImageSupprimer");
			String idImage = "";
			for (int i = 3; i < idImageString.length(); i++) { // 3 car id de la
																// forme "id=XX"
				idImage = idImage + idImageString.charAt(i);
			}
			int idImageInt = Integer.parseInt(idImage);
			imageDao.supprimerUneImage(idImageInt);
		}

		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/categorieGalerie.jsp");
		view.forward(request, response);
	}
}
