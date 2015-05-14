package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mr.dao.MenuDao;
import mr.entities.Article;
import mr.entities.Menu;

public class MenuDaoImpl implements MenuDao {

	//Afficher le Menu
	@Override
	public List<Menu> listerMenu() {
		List<Menu> maListMenu = new ArrayList<Menu>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT idpage, nompage, rang, visibilite FROM page ORDER BY idpage");
			while (rs.next()) {
				maListMenu.add(new Menu(rs.getInt("idpage"), rs.getString("nompage"), rs.getInt("rang"), rs.getBoolean ("visibilite")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maListMenu;
	}

	@Override
	public List<Menu> listerMenuDeRang0() {
		List<Menu> maListMenuRang0 = new ArrayList<Menu>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT idpage, nompage, rang, visibilite FROM page WHERE visibilite=1 AND rang = 0 ORDER BY idpage");
			while (rs.next()) {
				maListMenuRang0.add(new Menu(rs.getInt("idpage"), rs
						.getString("nompage"), rs.getInt("rang"), rs.getBoolean ("visibilite")));
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
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT idpage, nompage, rang, visibilite FROM PAGE WHERE visibilite=1 AND rang=1 AND idpage>= "
							+ premierRang0
							+ " AND idpage<= "
							+ secondRang0
							+ " ORDER BY idpage");
			while (rs.next()) {
				maListMenuRang1Entre2Rang0.add(new Menu(rs.getInt("idpage"), rs
						.getString("nompage"), rs.getInt("rang"), rs.getBoolean ("visibilite")));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maListMenuRang1Entre2Rang0;
	}
	
	@Override
	public List<Menu> listerMenuPageAvecArticle() {
		List<Menu> maListMenu = new ArrayList<Menu>();
		List<Menu> maListMenuPageAvecArticle = new ArrayList<Menu>();
		maListMenu = listerMenu();
		for (int i = 0; i < maListMenu.size()-1; i++) {
			if(maListMenu.get(i).getRang()!=0 || maListMenu.get(i+1).getRang()!=1)
			maListMenuPageAvecArticle.add(maListMenu.get(i));
		}
		maListMenuPageAvecArticle.add(maListMenu.get(maListMenu.size()-1));
		return maListMenuPageAvecArticle;
	}
	//Fonction generale
	@Override
	public void supprimerBaseDeDonneesMenu() {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"DELETE FROM page",
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void regenererBaseDeDonneesMenu(List<Menu> maNouvelleListe) {
		supprimerBaseDeDonneesMenu();
		for(int i=0;i<maNouvelleListe.size();i++){
			ajouterMenu(maNouvelleListe.get(i));
		}
		
	}
	
	//Ajouter un nouveau menu : besoin id precedent et nouveau menu
	@Override
	public void ajouterNouveauMenu(int idLigneprecedente, Menu nouveauMenu) {
		
		List<Menu> maListe = listeChangerOrdreNouveauId(idLigneprecedente,nouveauMenu);
		regenererBaseDeDonneesMenu(maListe);
	}
	
	//Fonction pour ajouter nouveau Menu
	@Override
	public List<Menu>  listeChangerOrdreNouveauId(int idLigneprecedente,
			Menu nouveauMenu) {
		
		List<Menu> maListe = listerMenu();
		List<Menu> maNewListe = new ArrayList<Menu>();
		if(idLigneprecedente==1000){
			nouveauMenu.setIdpage(0);
			maNewListe.add(nouveauMenu);
			for(int i=0; i < maListe.size() ; i++){
				maListe.get(i).setIdpage(i+1);
				maNewListe.add(maListe.get(i));
			}
		}else{
			for(int i=0; i <= idLigneprecedente ; i++){
				maNewListe.add(maListe.get(i));
			}
			nouveauMenu.setIdpage(idLigneprecedente+1);
			maNewListe.add(nouveauMenu);
			for(int i=idLigneprecedente+1; i < maListe.size() ; i++){
				maListe.get(i).setIdpage(i+1);
				maNewListe.add(maListe.get(i));
			}
		}
		
		return maNewListe;		
	}
	
	@Override
	public void ajouterMenu(Menu newMenu) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO page(idpage, nompage, rang, visibilite) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, newMenu.getIdpage());
			stmt.setString(2, newMenu.getNompage());
			stmt.setInt(3, newMenu.getRang());
			stmt.setBoolean(4, newMenu.getVisibilite());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	//Fonction pour supprimer un menu
	@Override
	public void supprimerMenu(int numeroArticle) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM `page` WHERE idpage =?");
			stmt.setInt(1, numeroArticle);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerLigneDansMenu(int idLignesupprimee) {
		List<Menu> maListe = listerMenu();
		List<Menu> maNewListe = new ArrayList<Menu>();
		
		for(int i=0;i<idLignesupprimee;i++){
			maNewListe.add(maListe.get(i));
		}
		for(int j=idLignesupprimee+1;j<maListe.size();j++){
			Menu mapage = maListe.get(j);
			int nb = mapage.getIdpage();
			mapage.setIdpage(nb-1);
			maNewListe.add(mapage);
		}
		regenererBaseDeDonneesMenu(maNewListe);
	}

	@Override
	public void modifierMenu(int nbPageModif, Menu nouveauMenuModif) {
		int nbnouveauMenuModif=nouveauMenuModif.getIdpage();
		if(nbPageModif> nouveauMenuModif.getIdpage() && nbPageModif!=1000){
			//pb descente
			ajouterNouveauMenu(nbPageModif, nouveauMenuModif);
			supprimerLigneDansMenu(nbnouveauMenuModif);
		}else{
			supprimerLigneDansMenu(nbnouveauMenuModif);
			ajouterNouveauMenu(nbPageModif, nouveauMenuModif);
		}	
	}

	@Override
	public Menu rechercheMenu(int id) {
		Connection connection;
		Menu menu = null;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt1= connection.prepareStatement("SELECT `idpage`, `nompage`, `rang`, `visibilite` FROM `page` WHERE idpage=?");
			stmt1.setInt(1, id); 
			ResultSet results = stmt1.executeQuery();
			while (results.next()) {
				menu= new Menu(results.getInt("idpage"),results.getString("nompage"),results.getInt("rang"),results.getBoolean("visibilite"));
				
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	
	
}
