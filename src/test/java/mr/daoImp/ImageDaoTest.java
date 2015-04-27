package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import mr.dao.ImageDao;
import mr.entities.Categorie;
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
		stmt.executeUpdate("INSERT INTO `photo`(`lienPhoto`,`idCategoriePhoto`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES ('lienversmaphoto1.jpg',1,'romain.soenen@hei.fr',NOW(),'ip romain')");
		stmt.executeUpdate("INSERT INTO `photo`(`lienPhoto`,`idCategoriePhoto`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES ('lienversmaphoto2.jpg',2,'michel.guignier@hei.fr',NOW(),'ip michel')");
		stmt.executeUpdate("INSERT INTO `photo`(`lienPhoto`,`idCategoriePhoto`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES ('lienversmaphoto3.jpg',1,'florent.soenen@hei.fr',NOW(),'ip florent')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListeImage() throws Exception{
		
		List<Image> listeImage=imageDao.listeImageCategorie(1);
		
		Assert.assertEquals(2, listeImage.size());
		
		Assert.assertEquals("lienversmaphoto1.jpg", listeImage.get(0).getLienImage());
		Assert.assertEquals("romain.soenen@hei.fr", listeImage.get(0).getMailPosteur());
		Assert.assertEquals("florent.soenen@hei.fr", listeImage.get(1).getMailPosteur());
		
	}
	
	@Test
	public void testAjoutImage() throws Exception{
		
		imageDao.ajouterImage(new Image("adresse4.jpg","romain@test.fr",2), "adresse rs");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM photo WHERE lienPhoto='adresse4.jpg'");
		ResultSet rs = stmt.executeQuery();
		
		Assert.assertTrue(rs.next());
		Assert.assertEquals("romain@test.fr", rs.getString("mailAuteur"));
		Assert.assertEquals("adresse rs", rs.getString("ipPosteur"));
		Assert.assertEquals(2, rs.getInt("idCategoriePhoto"));
		Assert.assertFalse(rs.next());
	}

	
}
