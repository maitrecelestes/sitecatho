package mr.entities;

import java.sql.Date;

public class Image {
	private String lienImage;
	private String mailPosteur;
	private String categorieImage;
	private Date datePoste;
	private int id;
	
	//Constructeur pour l'ajout dans la base de donnée
	public Image(String lienImage,String mailPosteur,String categorieImage){
		this.lienImage=lienImage;
		this.mailPosteur=mailPosteur;
		this.categorieImage=categorieImage;
	}
	
	//Constructeur quand on affiche les images
	public Image(int id,String lienImage,String mailPosteur,String categorieImage, Date date){
		this.id=id;
		this.lienImage=lienImage;
		this.mailPosteur=mailPosteur;
		this.categorieImage=categorieImage;
		this.datePoste=date;
	}

	public String getLienImage() {
		return lienImage;
	}

	public String getMailPosteur() {
		return mailPosteur;
	}

	public String getCategorieImage() {
		return categorieImage;
	}

	public Date getDatePoste() {
		return datePoste;
	}

	public int getId() {
		return id;
	}
	
	
}
