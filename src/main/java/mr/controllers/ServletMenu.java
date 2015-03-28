package mr.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mr.dao.MenuDao;
import mr.daoImp.MenuDaoImpl;
import mr.entities.Menu;

public class ServletMenu extends HttpServlet {

	private static final long serialVersionUID = -7041794190655964426L;
	MenuDao menuDao = new MenuDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		List<Menu> maListeMenu = menuDao.listerMenu() ;
		Gson gson = new Gson();
	    String json = gson.toJson(maListeMenu);
		
		
		PrintWriter out = response.getWriter(); /////////////////////////////////////////////////
		out.append(json);
		
	}
}
