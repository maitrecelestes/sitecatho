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
		stmt.executeUpdate("INSERT INTO `page`(`idpage`,`nompage`,`rang`) VALUES (10,'newpage',0)");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListerMenu() {
		List<Menu> menu = menuDao.listerMenu();
		Assert.assertEquals(9, menu.size());
		Assert.assertEquals(1, menu.get(0).getIdpage().intValue());
		Assert.assertEquals("Accueil", menu.get(1).getNompage());
		Assert.assertEquals(false, menu.get(2).getRang());
		
	}

}
