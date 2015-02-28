package mr.entities;

import java.sql.Date;

public class Utilisateur {
	private String mail;
	private String mdp;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String rang;
	private String ecole;
	
	public Utilisateur (String mail, String mdp,String nom, String prenom, Date dateDeNaissance, String rang, String ecole){
		this.mail=mail;
		this.mdp=mdp;
		this.nom=nom;
		this.prenom=prenom;
		this.dateDeNaissance=dateDeNaissance;
		this.rang=rang;
		this.ecole=ecole;
	}
	public Utilisateur (String mail,String mdp){
		this.mail=mail;
		this.mdp=mdp;
	}
	
	public String getMdp(){
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

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public String getRang() {
		return rang;
	}

	public String getEcole() {
		return ecole;
	}
	
}
