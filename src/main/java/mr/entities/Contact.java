package mr.entities;

import java.sql.Date;

public class Contact {
	private int idMessage;
	private String nom;
	private String prenom;
	private String objet;
	private String contenu;
	private String ipPosteur;
	private Date datePoste;
	
	//Constructeur pour la récupération de donnée depuis la bdd
	public Contact(int idMessage, String nom, String prenom, String objet, String contenu, String ipPosteur, Date datePoste){
		this.idMessage=idMessage;
		this.nom=nom;
		this.prenom=prenom;
		this.objet=objet;
		this.contenu=contenu;
		this.ipPosteur=ipPosteur;
		this.datePoste=datePoste;
	}
	
	//Constructeur pour ajouter des informations dans la bdd
	public Contact(String nom, String prenom, String objet, String contenu, String ipPosteur, Date datePoste){
		this.nom=nom;
		this.prenom=prenom;
		this.objet=objet;
		this.contenu=contenu;
		this.ipPosteur=ipPosteur;
		this.datePoste=datePoste;
	}
	
	public int getIdMessage() {
		return idMessage;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getObjet() {
		return objet;
	}

	public String getContenu() {
		return contenu;
	}

	public String getIpPosteur() {
		return ipPosteur;
	}

	public Date getDatePoste() {
		return datePoste;
	}

}
