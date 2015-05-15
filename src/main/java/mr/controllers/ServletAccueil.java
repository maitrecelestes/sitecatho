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

import com.google.gson.Gson;

import mr.dao.ArticleDao;
import mr.dao.ArticleUniqueDao;
import mr.dao.PhotoEnteteDao;
import mr.daoImp.ArticleDaoImp;
import mr.daoImp.ArticleUniqueDaoImp;
import mr.daoImp.PhotoEnteteDaoImp;
import mr.entities.Article;
import mr.entities.ArticleUnique;
import mr.entities.PhotoEntete;

@WebServlet("/accueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotoEnteteDao photoEnteteDao=new PhotoEnteteDaoImp();
	ArticleUniqueDao articleUniqueDao= new ArticleUniqueDaoImp();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PhotoEntete lienPhotoEntete=photoEnteteDao.afficherPhotoEntete("accueil");
		request.setAttribute("lienPhotoEntete",lienPhotoEntete);
		request.setAttribute("rangUtilisateur",request.getSession().getAttribute("rang"));
		
		
		ArticleUnique maListeArticleUnique = articleUniqueDao.listeArticleUnique("accueil") ;
	    request.setAttribute("listeArticleUnique",maListeArticleUnique);
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		view.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newLien=request.getParameter("newPhoto");
		String mail=(String) request.getSession().getAttribute("utilisateurConnecte");
		photoEnteteDao.ajouterNouvellePhoto(new PhotoEntete(newLien,"accueil"), InetAddress.getLocalHost().getHostAddress(), mail);
		
		PhotoEntete lienPhotoEntete=photoEnteteDao.afficherPhotoEntete("accueil");
		request.setAttribute("lienPhotoEntete",lienPhotoEntete);
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		view.forward(request, response);
	}
	
	
}
