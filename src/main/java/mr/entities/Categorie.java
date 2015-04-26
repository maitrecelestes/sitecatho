package mr.entities;

import java.sql.Date;

public class Categorie {
	private int id;
	private String nomCategorie;
	private Date dateCreation;
	
	public Categorie(String nomCategorie){ // Constructeur creation categorie
		this.nomCategorie=nomCategorie;
	}
	
	public Categorie(int id, String nomCategorie,Date dateCreation){ //Constructeur pour l'affichage
		this.id=id;
		this.nomCategorie=nomCategorie;
		this.dateCreation=dateCreation;
	}

	public int getId() {
		return id;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public Date getDateCreation() {
		return dateCreation;
	}
}
