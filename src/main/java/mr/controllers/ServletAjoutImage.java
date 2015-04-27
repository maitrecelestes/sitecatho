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

import mr.dao.CategorieDao;
import mr.dao.ImageDao;
import mr.daoImp.CategorieDaoImp;
import mr.daoImp.ImageDaoImp;
import mr.entities.Categorie;
import mr.entities.Image;

@WebServlet("/ajouterimage")
public class ServletAjoutImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieDao categorieDao=new CategorieDaoImp();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> listeCategorie=categorieDao.listeCategorie();
		request.setAttribute("listeCategorie", listeCategorie);
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/ajouterimage.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ImageDao imageDao= new ImageDaoImp();
		String nombreLienString=request.getParameter("nombrelien");
		System.out.println(nombreLienString);
		int nombreLien= Integer.parseInt(nombreLienString);
		
		String mail=(String) request.getSession().getAttribute("utilisateurConnecte");
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		
		
		String stringCategorie=request.getParameter("categorie");
		int idCategorie= Integer.parseInt(stringCategorie);
		for (int i=1;i<nombreLien+1;i++){
			String idLien="lien"+i;
			String adresseLien=request.getParameter(idLien);
			if (adresseLien.equals("")){
				
			}else {
				Image monimage= new Image(adresseLien,mail,idCategorie);
				imageDao.ajouterImage(monimage, ipAddress);
			}
			
		}
		
		
		
	}

}
