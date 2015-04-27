package mr.dao;

import java.util.List;

import mr.entities.Utilisateur;

public interface UtilisateurDao {
	
	public List<Utilisateur> afficherListeDeTousLesUtilisateur();
	
	public List<Utilisateur> afficherListeUtilisateurNonArchive();
	
	public Utilisateur afficherUtilisateur(String login);
	
	public void ajouterUtilisateur (Utilisateur newUtilisateur);
	
	public void supprimerUtilisateur (String mail);
	
	public void modifierUtilisateur(String mail, String rang,String ecole, String PageGere);
	
	public String HashMyPassword(String mdp) throws Exception;
	
	public boolean authentificationUtilisateur(Utilisateur utilisateur);
	
	//public boolean mailArchive(String mail);
}
