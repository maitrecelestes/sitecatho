package mr.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ServletArticle extends HttpServlet {

	private static final long serialVersionUID = -7041794190655964426L;
	ArticleDao articleDao = new ArticleDaoImp();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String fonction= request.getParameter("maFonction");
		if(fonction.equals("tousLesArticle")){
			String nomDeLaPage= request.getParameter("leNomDeMaPageChoisie");
			
			List<Article> maListeArticle = articleDao.listeArticlePage(nomDeLaPage) ;
			Gson gson = new Gson();
		    String json = gson.toJson(maListeArticle);
			
			
			PrintWriter out = response.getWriter();
			out.append(json);
		}else if(fonction.equals("unArticle")){
			String monid= request.getParameter("monid");
			
			Article monArticle = articleDao.unArticle(Integer.parseInt(monid)) ;
			Gson gson = new Gson();
		    String json = gson.toJson(monArticle);
			
			
			PrintWriter out = response.getWriter();
			out.append(json);
		}
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maFonction=request.getParameter("maFonction");
		if(maFonction.equals("archiveArticle")){
			articleDao.archiverArticle(Integer.parseInt(request.getParameter("idarticle")));
		}else if(maFonction.equals("visibleArticle")){
			articleDao.cacherArticle(Integer.parseInt(request.getParameter("idarticle")));
		}
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/maPageClassique.jsp");
		view.forward(request, response);
	}
	
}
