package mr.entities;

import java.sql.Date;

public class Article {
	private String contenu;
	private String mailAuteur;
	private Date date;
	private String page;
	private Boolean visiblePage;
	private Boolean articleDescription;
	
	
	public Article (String contenu, String mailAuteur, Date date, String page, Boolean visiblePage, Boolean articleDescription){
		this.contenu=contenu;
		this.mailAuteur=mailAuteur;
		this.date=date;
		this.page=page;
		this.visiblePage=visiblePage;
		this.articleDescription=articleDescription;
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
	
}
