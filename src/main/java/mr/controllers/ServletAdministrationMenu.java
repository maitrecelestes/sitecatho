package mr.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.entities.Contact;
import mr.entities.Menu;
import mr.dao.ContactDao;
import mr.dao.MenuDao;
import mr.daoImp.ContactDaoImp;
import mr.daoImp.MenuDaoImpl;

@WebServlet("/administrationMenu")
public class ServletAdministrationMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private MenuDao menuDao = new MenuDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getSession().getAttribute("utilisateurConnecte") == null || "".equals(request.getSession().getAttribute("utilisateurConnecte"))){
			
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);
			
		} else {		
			List<Menu> maListeMenu = menuDao.listerMenu() ;
			request.setAttribute("listeMenu", maListeMenu);
			
			RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationMenu.jsp");
			view.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maFonction=request.getParameter("maFonction");
		if(maFonction.equals("fonctionAjout")){
			//Ajout
			String nompage=request.getParameter("nompage");
			String nompageprecedente=request.getParameter("nompageprecedente");
			int nbPage=0;
			if(nompageprecedente.equals("page_0") ){
				nbPage=1000;
			}else{
				String lenompageprecedente="";
				if(nompageprecedente.length()==18){
					lenompageprecedente=""+nompageprecedente.charAt(17);
				}else if(nompageprecedente.length()==19){
					lenompageprecedente=""+nompageprecedente.charAt(17)+nompageprecedente.charAt(18);
				}
				else if(nompageprecedente.length()==20){
					lenompageprecedente=""+nompageprecedente.charAt(17)+nompageprecedente.charAt(18)+nompageprecedente.charAt(19);
				}
				nbPage=Integer.parseInt(lenompageprecedente);
			}
			String rang=request.getParameter("rang");	
			int leRang=1;
			if(rang.equals("true")){
				leRang=0;
			}
			String visibilite=request.getParameter("visibilite");
				
			
			Menu nouveauMenu= new Menu(0, nompage, leRang, Boolean.parseBoolean(visibilite));
			menuDao.ajouterNouveauMenu(nbPage, nouveauMenu);
		
			
			
		}else if(maFonction.equals("fonctionModification")){
			//Modification
			
			String idModif=request.getParameter("idModif");
			String nompageModif=request.getParameter("nompageModif");
			String nompageprecedenteModif=request.getParameter("nompageprecedenteModif");
			int nbPageModif=0;
			if(nompageprecedenteModif.equals("page_0")){
				nbPageModif=1000;
			}else{
				String lenompageprecedente="";
				if(nompageprecedenteModif.length()==23){
					lenompageprecedente=""+nompageprecedenteModif.charAt(22);
				}else if(nompageprecedenteModif.length()==24){
					lenompageprecedente=""+nompageprecedenteModif.charAt(22)+nompageprecedenteModif.charAt(23);
				}else if(nompageprecedenteModif.length()==25){
					lenompageprecedente=""+nompageprecedenteModif.charAt(22)+nompageprecedenteModif.charAt(23)+nompageprecedenteModif.charAt(24);
				}
				nbPageModif=Integer.parseInt(nompageprecedenteModif);
			}
			String rang=request.getParameter("rangModif");	
			int leRangModif=1;
			if(rang.equals("true")){
				leRangModif=0;
			}
			String visibiliteModif=request.getParameter("visibiliteModif");
			
		
			Menu nouveauMenuModif= new Menu(Integer.parseInt(idModif), nompageModif, leRangModif, Boolean.parseBoolean(visibiliteModif));
			menuDao.modifierMenu(nbPageModif, nouveauMenuModif);
			
			
			
		}else if(maFonction.equals("fonctionSuppression")){
			//Suppression
			String idString=request.getParameter("idpage");
			int id=Integer.parseInt(idString);
			menuDao.supprimerLigneDansMenu(id);
		}
		
		RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/administrationMenu.jsp");
		view.forward(request, response);
	
	}

}
