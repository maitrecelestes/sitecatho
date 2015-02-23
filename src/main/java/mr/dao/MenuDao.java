package mr.dao;

import java.util.List;

import mr.entities.Menu;

public interface MenuDao {
	
	//Afficher le Menu
		public List<Menu> listerMenu();
		public List<Menu> listerMenuDeRang0();
		public List<Menu> listerMenuDeRang1Entre2Rang0(int premierRang0, int secondRang0);
	
	//Fonction generale
		public void supprimerBaseDeDonneesMenu();
		public void regenererBaseDeDonneesMenu(List<Menu> maNouvelleListe);
	
	//Fonction pour ajouter nouveau Menu
		public List<Menu> listeChangerOrdreNouveauId(int idLigneprecedente, Menu nouveauMenu);
		void ajouterMenu(Menu newMenu);
	//Ajouter un nouveau menu : besoin id precedent et nouveau menu
		public void ajouterNouveauMenu(int idLigneprecedente, Menu nouveauMenu);
	
	
	//Fonction pour supprimer un menu
		void supprimerMenu(int numeroArticle);
		public void supprimerLigneDansMenu(int idLignesupprimee);
	

}

