package mr.entities;

import java.sql.Date;

public class Article {
	private int idArticle;
	private String contenu;
	private String titre;
	private String mailAuteur;
	private Date date;
	private String page;
	private Boolean visiblePage;
	private Boolean articleDescription;
	private Boolean archive;
	
	
	public Article (int idArticle, String contenu,String titre, String mailAuteur, Date date, String page, Boolean visiblePage, Boolean articleDescription, Boolean archive){
		this.idArticle=idArticle;
		this.contenu=contenu;
		this.titre=titre;
		this.mailAuteur=mailAuteur;
		this.date=date;
		this.page=page;
		this.visiblePage=visiblePage;
		this.articleDescription=articleDescription;
		this.archive=archive;
	}
	
	//Constructeur pour l'ajout d'un nouvelle article
	public Article (String contenu,String titre, String mailAuteur, String page, Boolean visiblePage, Boolean articleDescription){
		this.contenu=contenu;
		this.titre=titre;
		this.mailAuteur=mailAuteur;
		this.page=page;
		this.visiblePage=visiblePage;
		this.articleDescription=articleDescription;
		this.archive=false;
	}

	
	public int getIdArticle() {
		return idArticle;
	}

	public String getTitre() {
		return titre;
	}


	public String getContenu() {
		return contenu;
	}


	public String getMailAuteur() {
		return mailAuteur;
	}


	public Date getDate() {
		return date;
	}


	public String getPage() {
		return page;
	}


	public Boolean getVisiblePage() {
		return visiblePage;
	}


	public Boolean getArticleDescription() {
		return articleDescription;
	}

	public Boolean getArchive() {
		return archive;
	}

}
