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
	
	
	@Override
	public List<Menu> listerMenuDeRang0() {
		List<Menu> maListMenuRang0 = new ArrayList<Menu>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT idpage, nompage, rang FROM page WHERE rang = 0 ORDER BY idpage");
			while (rs.next()) {
				maListMenuRang0.add(new Menu(rs.getInt("idpage"), rs.getString("nompage"), rs.getInt("rang")/*, rs.getBoolean("visibilite")*/));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maListMenuRang0;
		
	}

	@Override
	public List<Menu> listerMenuDeRang1Entre2Rang0(int premierRang0,
			int secondRang0) {
		List<Menu> maListMenuRang1Entre2Rang0 = new ArrayList<Menu>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT idpage, nompage, rang FROM PAGE WHERE rang =0 AND idpage>= "+premierRang0+" AND idpage<= "+secondRang0+" ORDER BY idpage");
			while (rs.next()) {
				maListMenuRang1Entre2Rang0.add(new Menu(rs.getInt("idpage"), rs.getString("nompage"), rs.getInt("rang")/*, rs.getBoolean("visibilite")*/));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maListMenuRang1Entre2Rang0;
	}

	@Override
	public int chercherSuivantRang0(int idpremierRang0) {
		List<Menu> maListMenu = listerMenu();
		int nombreDeMenu = maListMenu.size();
		
		if(maListMenu.get(idpremierRang0).getRang()==0 && idpremierRang0+1 != nombreDeMenu){
			
			
			int i=0;
			while(i<nombreDeMenu && maListMenu.get(i+1).getRang()==1){
				i=i+1;
			}
				return idpremierRang0+i+1;			
		}else{
			return -1;
		}
		
	}

}
