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
	private ImageDao imageDao= new ImageDaoImp();
	private CategorieDao categorieDao=new CategorieDaoImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer requestURL = request.getRequestURL();
		if (request.getQueryString() != null) {
		    requestURL.append("?").append(request.getQueryString());
		}
		String completeURL = requestURL.toString();
		
		String id="";
		int i=completeURL.length();
		while(i>1&&completeURL.charAt(i-1)!='='){
			i--;
			id=completeURL.charAt(i)+id;
		}
		int idCategorie= Integer.parseInt(id);
		Categorie maCategorie=categorieDao.afficherUneCategorie(idCategorie);
		List<Image> listeImage=imageDao.listeImageCategorie(idCategorie);
		
		request.setAttribute("rangUtilisateur",request.getSession().getAttribute("rang"));
		request.setAttribute("listeImage", listeImage);
		request.setAttribute("maCategorie", maCategorie);
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/categorieGalerie.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/categorieGalerie.jsp");
		view.forward(request, response);
	}
}

