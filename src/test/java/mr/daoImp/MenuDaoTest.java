package mr.daoImp;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mr.dao.MenuDao;
import mr.daoImp.DataSourceProvider;
import mr.daoImp.MenuDaoImpl;
import mr.entities.Menu;



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

}
