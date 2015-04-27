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
import mr.daoImp.CategorieDaoImp;
import mr.entities.Categorie;


@WebServlet("/galerie")
public class ServletGalerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieDao categorieDao= new CategorieDaoImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Categorie> listeCategorie=categorieDao.listeCategorie();
		request.setAttribute("listeCategorie", listeCategorie);
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/galerie.jsp");
		view.forward(request, response);
	}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
