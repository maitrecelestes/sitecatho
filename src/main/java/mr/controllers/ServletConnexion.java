package mr.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mr.dao.UtilisateurDao;
import mr.daoImp.UtilisateurDaoImp;
import mr.entities.Utilisateur;

@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurDao utilisateurdao = new UtilisateurDaoImp();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("utilisateurConnecte") == null
				|| "".equals(request.getSession().getAttribute(
						"utilisateurConnecte"))) {
			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/connexion.jsp");
			request.setAttribute("dejaConnecter", "faux");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/connexion.jsp");
			request.setAttribute("dejaConnecter", "vrai");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view;

		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		Utilisateur utilisateur = new Utilisateur(mail, mdp);
		boolean authentificationReussi = utilisateurdao
				.authentificationUtilisateur(utilisateur);
		if (authentificationReussi) {
			Utilisateur utilisateurConnecte = utilisateurdao
					.afficherUtilisateur(mail);
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateurConnecte", mail);
			session.setAttribute("rang", utilisateurConnecte.getRang());
			session.setAttribute("pageGere", utilisateurConnecte.getPageGere());
			session.setAttribute("nom", utilisateurConnecte.getNom());
			session.setAttribute("prenom", utilisateurConnecte.getPrenom());
			request.setAttribute("rangUtilisateur", request.getSession()
					.getAttribute("rang"));
			view = request.getRequestDispatcher("/WEB-INF/connexionreussi.jsp");

		} else {
			request.setAttribute("testConnexion", "faux");
			request.setAttribute("dejaConnecter", "faux");
			view = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		}

		view.forward(request, response);

	}
}