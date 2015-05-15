package mr.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ArticleDao;
import mr.dao.ArticleUniqueDao;
import mr.daoImp.ArticleDaoImp;
import mr.daoImp.ArticleUniqueDaoImp;
import mr.entities.Article;
import mr.entities.ArticleUnique;

import com.google.gson.Gson;

public class ServletArticleUnique extends HttpServlet {

	private static final long serialVersionUID = -7041794190655964426L;
	ArticleUniqueDao articleDaoUniqueDao = new ArticleUniqueDaoImp();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String nomDeLaPage= request.getParameter("nompage");
		
		ArticleUnique maListeArticleUnique = articleDaoUniqueDao.listeArticleUnique(nomDeLaPage) ;
		Gson gson = new Gson();
		String json = gson.toJson(maListeArticleUnique);
		PrintWriter out = response.getWriter();
		out.append(json);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}
	
}
