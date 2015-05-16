package mr.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ArticleUniqueDao;
import mr.dao.MenuDao;
import mr.daoImp.ArticleUniqueDaoImp;
import mr.daoImp.MenuDaoImpl;
import mr.entities.ArticleUnique;

import com.google.gson.Gson;

public class ServletBlocDeGauche extends HttpServlet {

	private static final long serialVersionUID = -7041794190655964426L;
	MenuDao menuDao = new MenuDaoImpl();
	ArticleUniqueDao articleUniqueDao = new ArticleUniqueDaoImp();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ArticleUnique articleUniqueBlocGauche = articleUniqueDao
				.listeArticleUnique("informationBlocGauche");
		Gson gson = new Gson();
		String json = gson.toJson(articleUniqueBlocGauche);

		PrintWriter out = response.getWriter();
		out.append(json);

	}
}
