package mr.daoImp;

import java.sql.Connection;
import java.sql.Statement;

import mr.dao.PhotoEnteteDao;
import mr.entities.PhotoEntete;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhotoEnteteDaoTest {
	
	PhotoEnteteDao photoEnteteDao=new PhotoEnteteDaoImp();
	
	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM `photoentete`");
		stmt.executeUpdate("INSERT INTO `photoentete`(`LienPhoto`, `PagePhoto`, `IpPosteur`, `mailPosteur`, `datePoste`) VALUES ('lien1','accueil','ip 1','mail 1',NOW())");
		stmt.executeUpdate("INSERT INTO `photoentete`(`LienPhoto`, `PagePhoto`, `IpPosteur`, `mailPosteur`, `datePoste`) VALUES ('lien2','maPageClassique?nompage=Bureau','ip 2','mail 2',NOW())");
		stmt.executeUpdate("INSERT INTO `photoentete`(`LienPhoto`, `PagePhoto`, `IpPosteur`, `mailPosteur`, `datePoste`) VALUES ('lien3','maPageClassique?nompage=Bureau2','ip 3','mail 3',NOW())");
		stmt.close();
		connection.close();
	}
	
	
	@Test
	public void testAfficherPhotoEntete() {
		PhotoEntete photoEnteteAccueil=photoEnteteDao.afficherPhotoEntete("accueil");
		PhotoEntete photoEnteteBureau=photoEnteteDao.afficherPhotoEntete("maPageClassique?nompage=Bureau");
		
		Assert.assertEquals("lien1", photoEnteteAccueil.getLienImage());
		Assert.assertEquals("lien2", photoEnteteBureau.getLienImage());
		
	}
}
