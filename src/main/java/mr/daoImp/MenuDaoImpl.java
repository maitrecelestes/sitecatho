package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.impl.DataSourceProvider;
import entities.Personne;
import mr.dao.MenuDao;
import mr.entities.Menu;

public class MenuDaoImpl implements MenuDao {

	@Override
	public List<Menu> listerMenu() {
		List<Menu> maListMenu = new ArrayList<Menu>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT idpage, nompage, rang FROM page ORDER BY idpage");
			while (rs.next()) {
				maListMenu.add(new Menu(rs.getInt("idpage"), rs.getString("nompage"), rs.getInt("rang")/*, rs.getBoolean("visibilite")*/));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maListMenu;
	}

	@Override
	public Menu getMenu(Integer id) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT idpage, nompage, rang FROM page WHERE idpage = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Menu(rs.getInt("idpage"), rs.getString("nompage"), rs.getInt("rang")/*, rs.getBoolean("visibilite")*/);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
