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


@WebServlet("/galerie")
public class ServletGalerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieDao categorieDao= new CategorieDaoImp();
	private ImageDao imageDao=new ImageDaoImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Categorie> listeCategorie=categorieDao.listeCategorie();
		request.setAttribute("listeCategorie", listeCategorie);
		request.setAttribute("rangUtilisateur",request.getSession().getAttribute("rang"));
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/galerie.jsp");
		view.forward(request, response);
	}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requete=request.getParameter("action");
		if(requete==null){
			requete="null";
		}
		if(requete.equals("suppressionCategorie")){
			String idCategorieString=request.getParameter("idCategorieSupprimer");
			String id="";
			for (int i=2;i<idCategorieString.length();i++){
				id=id+idCategorieString.charAt(i);
			}
			int idCategorie=Integer.parseInt(id);
			categorieDao.supprimerCategorie(idCategorie);
			
		} else {
			String nomCategorie=request.getParameter("nomNouvelleCategorie");
			Categorie maNouvelleCategorie=new Categorie(nomCategorie);
			categorieDao.ajoutCategorie(maNouvelleCategorie);
		}
	
		
		
		List<Categorie> listeCategorie=categorieDao.listeCategorie();
		request.setAttribute("listeCategorie", listeCategorie);
		request.setAttribute("rangUtilisateur",request.getSession().getAttribute("rang"));
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/galerie.jsp");
		view.forward(request, response);
	}


}
