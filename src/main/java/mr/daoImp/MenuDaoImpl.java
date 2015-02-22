package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public void ajouterMenu(Menu newMenu) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO page(idpage, nompage, rang) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, newMenu.getIdpage());
			stmt.setString(2, newMenu.getNompage());
			stmt.setInt(3, newMenu.getRang());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimerMenu(int numeroArticle) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("DELETE FROM `page` WHERE idpage =?");
			stmt.setInt(1,numeroArticle); 
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
