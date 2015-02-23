package mr.dao;

import java.util.List;

import mr.entities.Menu;

public interface MenuDao {
	public List<Menu> listerMenu();
	void ajouterMenu(Menu newMenu);
	void supprimerMenu(int numeroArticle);
	public List<Menu> listerMenuDeRang0();
	public List<Menu> listerMenuDeRang1Entre2Rang0(int premierRang0, int secondRang0);
	public int chercherSuivantRang0(int premierRang0);
	

}
