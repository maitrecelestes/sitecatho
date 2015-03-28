package mr.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ServletGestionSession
 */
public class ServletGestionSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionSession() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("utilisateurConnecte") == null || "".equals(request.getSession().getAttribute("utilisateurConnecte"))) {
			
		} else {
			System.out.println(request.getSession().getAttribute("utilisateurConnecte"));
			String mail=(String) request.getSession().getAttribute("utilisateurConnecte");
			String rang=(String) request.getSession().getAttribute("rang");
			String pageGere=(String) request.getSession().getAttribute("pageGere");
			ArrayList<String> informationUtilisateur=new ArrayList<String>();
			informationUtilisateur.add(mail);
			informationUtilisateur.add(rang);
			informationUtilisateur.add(pageGere);
			
			Gson gson = new Gson();
		    String json = gson.toJson(informationUtilisateur);
			
		    PrintWriter out = response.getWriter();
			out.append(json);
		}
	}


}
