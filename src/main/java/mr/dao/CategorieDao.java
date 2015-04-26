package mr.dao;

import java.util.List;

import mr.entities.Categorie;

public interface CategorieDao {

	public List<Categorie> listeCategorie(); 
	public void ajoutCategorie(Categorie nomCategorie);
	public void modifierCategorie(int idCategorie, String newNomCategorie);
}
