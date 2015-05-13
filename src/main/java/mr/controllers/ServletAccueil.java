package mr.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.PhotoEnteteDao;
import mr.daoImp.PhotoEnteteDaoImp;
import mr.entities.PhotoEntete;

@WebServlet("/accueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotoEnteteDao photoEnteteDao=new PhotoEnteteDaoImp();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PhotoEntete lienPhotoEntete=photoEnteteDao.afficherPhotoEntete("accueil");
		request.setAttribute("lienPhotoEntete",lienPhotoEntete);
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		view.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newLien=request.getParameter("newPhoto");
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		view.forward(request, response);
	}
	
	
}
