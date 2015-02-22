package mr.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.MenuDao;
import mr.daoImp.MenuDaoImpl;
import mr.entities.Menu;

@WebServlet("/menu")
public class ServletMenu extends HttpServlet {

	private static final long serialVersionUID = 8558122731317034877L;
	MenuDao menuDao = new MenuDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);	
		
		/*Menu menu = getMenu(4);
		request.setAttribute("menu", menu);
		System.out.println("coucou");
		/*MenuDao menuDao = new MenuDaoImpl();
		List<Menu> menu = menuDao.listerMenu();
		request.setAttribute("listeMenu", menu);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/menu.jsp");
		view.forward(request, response);*/
	}
	
	
	
	
	
	/*public Menu getMenu(Integer id) {
		return menuDao.getMenu(id);
	}*/
}
