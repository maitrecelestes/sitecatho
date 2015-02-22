package mr.dao;

import java.util.List;

import mr.entities.Menu;

public interface MenuDao {
	public List<Menu> listerMenu();
	void ajouterMenu(Menu newMenu);
	void supprimerMenu(int numeroArticle);

	

}
