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

@WebServlet("/modificationarticleunique")
public class ServletModifierArticleUnique extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("utilisateurConnecte") == null || "".equals(request.getSession().getAttribute("utilisateurConnecte"))){
			
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);
			
		} else {
			
			if (request.getSession().getAttribute("rang").equals("administrateur")||(request.getSession().getAttribute("rang").equals("redacteur")&&request.getSession().getAttribute("pageGere").equals(request.getParameter("nompage")))){
				
				RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/modifierarticleUnique.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
				view.forward(request, response);
			}
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/////////////////////////////////////////////////////////////////////////////
		String fonction=request.getParameter("maFonction");
		if(fonction.equals("accueil")){
			String page=request.getParameter("nompage");
			response.sendRedirect("modifierarticleUnique?nompage="+page);
			
		}
		
		
	}

}
