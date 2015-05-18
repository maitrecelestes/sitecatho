package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		Assert.assertEquals("lien1", photoEnteteAccueil.getLienPhoto());
		Assert.assertEquals("lien2", photoEnteteBureau.getLienPhoto());
	}
	
	@Test
	public void testAjouterImage() throws SQLException {
		photoEnteteDao.ajouterNouvellePhoto(new PhotoEntete("lien 4","accueil"), "ip 4", "mail 4");
		photoEnteteDao.ajouterNouvellePhoto(new PhotoEntete("lien 5","accueil1"), "ip 5", "mail 5");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM photoentete WHERE PagePhoto=?");
		stmt1.setString(1, "accueil");
		ResultSet rs1 = stmt1.executeQuery();
		
		PreparedStatement stmt2 = connection.prepareStatement("SELECT * FROM photoentete WHERE PagePhoto=?");
		stmt2.setString(1, "accueil1");
		ResultSet rs2 = stmt2.executeQuery();
		
		Assert.assertTrue(rs1.next());
		Assert.assertEquals("ip 4", rs1.getString("IpPosteur"));
		Assert.assertEquals("lien 4", rs1.getString("LienPhoto"));
		Assert.assertFalse(rs1.next());
	
		Assert.assertTrue(rs2.next());
		Assert.assertEquals("ip 5", rs2.getString("IpPosteur"));
		Assert.assertEquals("lien 5", rs2.getString("LienPhoto"));
		Assert.assertFalse(rs2.next());
	}
}
