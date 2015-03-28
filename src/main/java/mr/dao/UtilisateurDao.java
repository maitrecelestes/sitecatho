package mr.dao;

import java.util.List;

import mr.entities.Utilisateur;

public interface UtilisateurDao {
	public List<Utilisateur> afficherListeUtilisateur();
	
	public Utilisateur afficherUtilisateur(String login);
	
	public void ajouterUtilisateur (Utilisateur newUtilisateur);
	
	public void supprimerUtilisateur (String mail);
	
	public void modifierUtilisateur(String mail, String rang);
	
	public String HashMyPassword(String mdp) throws Exception;
	
	public boolean authentificationUtilisateur(Utilisateur utilisateur);
	
	
}
