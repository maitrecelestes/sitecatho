package mr.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import mr.dao.MenuDao;
import mr.daoImp.ArticleDaoImp;
import mr.daoImp.MenuDaoImpl;
import mr.entities.Article;
import mr.entities.Menu;

@WebServlet("/modifierarticle")
public class ServletModifierArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao = new ArticleDaoImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/modifierarticle.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contenu=request.getParameter("contenu");
		String titre=request.getParameter("titre");
		String mail=(String) request.getSession().getAttribute("utilisateurConnecte");
		String page=request.getParameter("nompage");
		
		String visibilitePageString=request.getParameter("visibiliteArticle");
		Boolean visiblePage=false;
		if(visibilitePageString.equals("oui")){
			visiblePage=true;
		}
		Boolean articleDescription=false;
		Article monNouvelArticle=new Article(contenu,titre,mail,page,visiblePage,articleDescription);
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		ArticleDao articleDao= new ArticleDaoImp();
		articleDao.ajouterArticle(monNouvelArticle,ipAddress);
		
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/maPageClassique.jsp");
		view.forward(request, response);
		
	}

}
