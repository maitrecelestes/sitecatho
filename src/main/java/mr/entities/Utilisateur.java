package mr.entities;

public class Utilisateur {
	private String mail;
	private int idUtilisateur;
	private String mdp;
	private String nom;
	private String prenom;
	private String rang;
	private String ecole;
	private String pageGere;

	// POUR AFFICHAGE UTILISATEUR
	public Utilisateur(String mail, int idUtilisateur, String mdp, String nom,
			String prenom, String rang, String ecole, String pageGere) {
		this.mail = mail;
		this.idUtilisateur = idUtilisateur;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.rang = rang;
		this.ecole = ecole;
		this.pageGere = pageGere;
	}

	// POUR NOUVEAU UTILISATEUR
	public Utilisateur(String mail, String mdp, String nom, String prenom,
			String rang, String ecole, String pageGere) {
		this.mail = mail;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.rang = rang;
		this.ecole = ecole;
		this.pageGere = pageGere;
	}

	// POUR LE CONNEXION
	public Utilisateur(String mail, String mdp) {
		this.mail = mail;
		this.mdp = mdp;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public String getMdp() {
		return mdp;
	}

	public String getMail() {
		return mail;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getRang() {
		return rang;
	}

	public String getEcole() {
		return ecole;
	}

	public String getPageGere() {
		return pageGere;
	}

}
