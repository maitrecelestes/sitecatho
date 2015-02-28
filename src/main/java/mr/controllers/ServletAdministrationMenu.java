package mr.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.entities.Menu;
import mr.dao.MenuDao;
import mr.daoImp.MenuDaoImpl;

@WebServlet("/administrationMenu")
public class ServletAdministrationMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private MenuDao menuDao = new MenuDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Menu> maListeMenu = menuDao.listerMenu() ;
		request.setAttribute("listeMenu", maListeMenu);
		
		List<Menu> maListeMenuRang0 = menuDao.listerMenuDeRang0() ;
		request.setAttribute("listeMenuRang0", maListeMenuRang0);
		
		List<Menu> listerMenuDeRang1Entre2Rang0 = menuDao.listerMenuDeRang1Entre2Rang0(1, 3) ;
		request.setAttribute("listerMenuDeRang1Entre2Rang0", listerMenuDeRang1Entre2Rang0);
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationMenu.jsp");
		view.forward(request, response);
	}

}
