package mr.dao;

import java.util.List;

import mr.entities.Categorie;
import mr.entities.Image;

public interface CategorieDao {

	public List<Categorie> listeCategorie();

	public Categorie afficherUneCategorie(int idCategorie);

	public void ajoutCategorie(Categorie nomCategorie);

	public void modifierCategorie(int idCategorie, String newNomCategorie);

	public void supprimerCategorie(int idCategorie);

	public List<Image> listePremiereImage();
}
