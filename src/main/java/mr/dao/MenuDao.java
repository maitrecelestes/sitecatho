package mr.dao;

import java.util.List;

import mr.entities.Menu;

public interface MenuDao {
	public List<Menu> listerMenu();

	Menu getMenu(Integer id);

	

}
