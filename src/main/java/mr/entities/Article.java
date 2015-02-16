package mr.entities;

import java.util.Date;

public class Article {
	private String contenu;
	private String mailAuteur;
	private Date date;
	
	public Article (String contenu, String mailAuteur){
		this.contenu=contenu;
		this.mailAuteur=mailAuteur;
	}
}
