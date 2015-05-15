package mr.entities;

import java.sql.Date;

public class ArticleUnique {
	private String nomPage;
	private String mailAuteur;
	private Date dateCreation;
	private String contenu;
	private String titre;

	public ArticleUnique(String nomPage, String mailAuteur, Date dateCreation,
			String contenu, String titre) {
		this.nomPage = nomPage;
		this.mailAuteur = mailAuteur;
		this.dateCreation = dateCreation;
		this.contenu = contenu;
		this.titre = titre;
	}

	// Constructeur pour l'ajout d'un nouvelle article
	public ArticleUnique(String nomPage, String mailAuteur, String contenu,
			String titre) {
		this.nomPage = nomPage;
		this.mailAuteur = mailAuteur;
		this.contenu = contenu;
		this.titre = titre;
	}

	public String getNomPage() {
		return nomPage;
	}

	public String getMailAuteur() {
		return mailAuteur;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public String getContenu() {
		return contenu;
	}

	public String getTitre() {
		return titre;
	}

}
