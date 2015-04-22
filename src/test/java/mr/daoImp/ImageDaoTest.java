package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mr.dao.ImageDao;
import mr.entities.Image;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImageDaoTest {
	
	ImageDao imageDao=new ImageDaoImp();
	
	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM photo");
		stmt.executeUpdate("INSERT INTO `photo`(`lienPhoto`,`categoriePhotos`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES ('lienversmaphoto1.jpg','categorie 1','romain.soenen@hei.fr',NOW(),'ip romain')");
		stmt.executeUpdate("INSERT INTO `photo`(`lienPhoto`,`categoriePhotos`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES ('lienversmaphoto2.jpg','categorie 2','michel.guignier@hei.fr',NOW(),'ip michel')");
		stmt.executeUpdate("INSERT INTO `photo`(`lienPhoto`,`categoriePhotos`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES ('lienversmaphoto3.jpg','categorie 1','florent.soenen@hei.fr',NOW(),'ip florent')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testAjouterUtilisateur() throws Exception{
		
		imageDao.ajouterImage(new Image("adresse4.jpg","romain@test.fr","categorie 2"), "adresse rs");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM photo WHERE lienPhoto='adresse4.jpg'");
		ResultSet rs = stmt.executeQuery();
		
		Assert.assertTrue(rs.next());
		Assert.assertEquals("romain@test.fr", rs.getString("mailAuteur"));
		Assert.assertEquals("adresse rs", rs.getString("ipPosteur"));
		Assert.assertEquals("categorie 2", rs.getString("categoriePhotos"));
		Assert.assertFalse(rs.next());
	}

	
}
