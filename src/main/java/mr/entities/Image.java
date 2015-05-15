package mr.entities;

import java.sql.Date;

public class Image {
	private String lienImage;
	private String mailPosteur;
	private int idCategorieImage;
	private Date datePoste;
	private int id;
	
	//Constructeur pour l'ajout dans la base de donnée
	public Image(String lienImage,String mailPosteur,int idCategorieImage){
		this.lienImage=lienImage;
		this.mailPosteur=mailPosteur;
		this.idCategorieImage=idCategorieImage;
	}
	
	// Constructeur quand on affiche les images
	public Image(int id, String lienImage, String mailPosteur,int idCategorieImage, Date date){
		this.id=id;
		this.lienImage=lienImage;
		this.mailPosteur=mailPosteur;
		this.idCategorieImage=idCategorieImage;
		this.datePoste=date;
	}

	public String getLienImage() {
		return lienImage;
	}

	public String getMailPosteur() {
		return mailPosteur;
	}

	public int getIdCategorieImage() {
		return idCategorieImage;
	}

	public Date getDatePoste() {
		return datePoste;
	}

	public int getId() {
		return id;
	}
	
	
}
