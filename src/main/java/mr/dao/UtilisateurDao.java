package mr.dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import mr.entities.Utilisateur;

public interface UtilisateurDao {
	public List<Utilisateur> afficherListeUtilisateur();
	
	public void ajouterUtilisateur (Utilisateur newUtilisateur);
	
	public void supprimerUtilisateur (String mail);
	
	public String crypteMdp(String mdp) throws NoSuchAlgorithmException;
	
	public boolean authentificationUtilisateur(Utilisateur utilisateur);
	
	
}
