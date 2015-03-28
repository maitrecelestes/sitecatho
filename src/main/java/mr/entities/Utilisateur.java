package mr.entities;

import java.sql.Date;

public class Utilisateur {
	private String mail;
	private String mdp;
	private String nom;
	private String prenom;
	private String rang;
	private String ecole;
	private String pageGere;
	
	public Utilisateur (String mail, String mdp,String nom, String prenom, String rang, String ecole,String pageGere){
		this.mail=mail;
		this.mdp=mdp;
		this.nom=nom;
		this.prenom=prenom;
		this.rang=rang;
		this.ecole=ecole;
		this.pageGere=pageGere;
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
