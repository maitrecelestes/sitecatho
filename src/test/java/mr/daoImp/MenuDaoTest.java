package mr.daoImp;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import mr.dao.MenuDao;
import mr.entities.Article;
import mr.entities.Menu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class MenuDaoTest {

	private MenuDao menuDao = new MenuDaoImpl();

	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM page");
		stmt.executeUpdate("INSERT INTO `page`(`idpage`,`nompage`,`rang`) VALUES (0,'Antenne',0)");
		stmt.executeUpdate("INSERT INTO `page`(`idpage`,`nompage`,`rang`) VALUES (1,'Antenne Inge',1)");
		stmt.executeUpdate("INSERT INTO `page`(`idpage`,`nompage`,`rang`) VALUES (2,'Antenne Droit',1)");
		stmt.executeUpdate("INSERT INTO `page`(`idpage`,`nompage`,`rang`) VALUES (3,'Accueil',0)");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListerMenu() {
		List<Menu> menu = menuDao.listerMenu();
		Assert.assertEquals(4, menu.size());
		Assert.assertEquals(0, menu.get(0).getIdpage());
		Assert.assertEquals("Antenne Inge", menu.get(1).getNompage());
		Assert.assertEquals(1, menu.get(2).getRang());
		
	}
	
	
	@Test
	public void testAjouterMenu() {
		Menu nouveauMenu=new Menu(4, "maNouvellePage", 0);
		menuDao.ajouterMenu(nouveauMenu);
		List<Menu> menu = menuDao.listerMenu();
		Assert.assertEquals(5, menu.size());
		Assert.assertEquals(4, menu.get(4).getIdpage());
		Assert.assertEquals("maNouvellePage", menu.get(4).getNompage());
		Assert.assertEquals(0, menu.get(4).getRang());	
	}
	
	@Test
	public void testSupprimerMenu() {
		menuDao.supprimerMenu(1);
		List<Menu> menu = menuDao.listerMenu();
		Assert.assertEquals(3, menu.size());
		Assert.assertEquals(3, menu.get(2).getIdpage());
		Assert.assertEquals("Accueil", menu.get(2).getNompage());
	}
	
	@Test
	public void testlisterMenuDeRang0() {
		List<Menu> menu = menuDao.listerMenuDeRang0();
		Assert.assertEquals(2, menu.size());
			
	}
	
	@Test
	public void testlisterMenuDeRang1Entre2Rang0() {
		List<Menu> menu = menuDao.listerMenuDeRang1Entre2Rang0(0,3);
		Assert.assertEquals(2, menu.size());
			
	}
	
	
	@Test
	public void testlisteChangerOrdreNouveauId() {	
		List<Menu> menu = menuDao.listerMenu();
		Assert.assertEquals(4, menu.size());
		Menu nouveauMenu=new Menu(1, "maNouvellePage", 0);
		Assert.assertEquals(5, menuDao.listeChangerOrdreNouveauId(1,nouveauMenu).size());
		List<Menu> newMenu = menuDao.listeChangerOrdreNouveauId(1,nouveauMenu);
		Assert.assertEquals("Antenne", newMenu.get(0).getNompage());
		Assert.assertEquals("Antenne Inge", newMenu.get(1).getNompage());
		Assert.assertEquals("maNouvellePage", newMenu.get(2).getNompage());
		Assert.assertEquals("Antenne Droit", newMenu.get(3).getNompage());
		Assert.assertEquals("Accueil", newMenu.get(4).getNompage());
	}
	
	@Test
	public void testSupprimerBaseDeDonneesMenu() {	
		menuDao.supprimerBaseDeDonneesMenu();
		List<Menu> menu = menuDao.listerMenu();
		Assert.assertEquals(0, menu.size());
	}
	
	@Test
	public void testRegenererBaseDeDonneesMenu() {	
		Menu nouveauMenu=new Menu(1, "maNouvellePage", 0);
		List<Menu> maNouvelleListe = menuDao.listeChangerOrdreNouveauId(1, nouveauMenu);
		menuDao.regenererBaseDeDonneesMenu(maNouvelleListe);
		List<Menu> menu = menuDao.listerMenu();
		Assert.assertEquals(5, menu.size());
		Assert.assertEquals("Antenne", menu.get(0).getNompage());
		Assert.assertEquals("Antenne Inge", menu.get(1).getNompage());
		Assert.assertEquals("maNouvellePage", menu.get(2).getNompage());
		Assert.assertEquals("Antenne Droit", menu.get(3).getNompage());
		Assert.assertEquals("Accueil", menu.get(4).getNompage());
	}
	
	@Test
	public void testListeChangerOrdreSupprimerId() {	
		menuDao.supprimerLigneDansMenu(2);
		//menuDao.regenererBaseDeDonneesMenu(maNouvelleListe);
		List<Menu> menu = menuDao.listerMenu();
		Assert.assertEquals(3, menu.size());
		Assert.assertEquals("Antenne", menu.get(0).getNompage());
		Assert.assertEquals("Antenne Inge", menu.get(1).getNompage());
		//Assert.assertEquals("Antenne Droit", menu.get(3).getNompage());
		Assert.assertEquals("Accueil", menu.get(2).getNompage());
		Assert.assertEquals(2, menu.get(2).getIdpage());
	}
	
}
