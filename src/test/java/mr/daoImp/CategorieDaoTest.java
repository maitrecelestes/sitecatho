package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import mr.dao.CategorieDao;
import mr.entities.Categorie;
import mr.entities.Image;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategorieDaoTest {
private CategorieDao categorieDao = new CategorieDaoImp();
	
	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM categoriephotos");
		stmt.executeUpdate("INSERT INTO `categoriephotos`(`id`, `nomCategorie`, `dateCreation`) VALUES (1,'Categorie 1',NOW())");
		stmt.executeUpdate("INSERT INTO `categoriephotos`(`id`, `nomCategorie`, `dateCreation`) VALUES (2,'Categorie 2',NOW())");
		stmt.executeUpdate("INSERT INTO `categoriephotos`(`id`, `nomCategorie`, `dateCreation`) VALUES (3,'Categorie 3',NOW())");
		stmt.executeUpdate("DELETE FROM photo");
		stmt.executeUpdate("INSERT INTO `photo`(`id`,`lienPhoto`,`idCategoriePhoto`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES (1,'lienversmaphoto1.jpg',1,'romain.soenen@hei.fr',NOW(),'ip romain')");
		stmt.executeUpdate("INSERT INTO `photo`(`id`,`lienPhoto`,`idCategoriePhoto`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES (2,'lienversmaphoto2.jpg',2,'michel.guignier@hei.fr',NOW(),'ip michel')");
		stmt.executeUpdate("INSERT INTO `photo`(`id`,`lienPhoto`,`idCategoriePhoto`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES (3,'lienversmaphoto3.jpg',1,'florent.soenen@hei.fr',NOW(),'ip florent')");
		stmt.executeUpdate("INSERT INTO `photo`(`id`,`lienPhoto`,`idCategoriePhoto`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES (4,'lienversmaphoto4.jpg',3,'paul.binoit@hei.fr',NOW(),'ip binoit')");
		stmt.close();
		connection.close();
	}
	
	
	@Test
	public void testListeCategorie() {
		List<Categorie> listeCategorie=categorieDao.listeCategorie();
		
		Assert.assertEquals(3, listeCategorie.size());
		
		Assert.assertEquals(1, listeCategorie.get(0).getId());
		Assert.assertEquals("Categorie 1", listeCategorie.get(0).getNomCategorie());
		Assert.assertEquals("Categorie 2", listeCategorie.get(1).getNomCategorie());
		Assert.assertEquals(2, listeCategorie.get(1).getId());
		Assert.assertEquals("Categorie 3", listeCategorie.get(2).getNomCategorie());
		Assert.assertEquals(3, listeCategorie.get(2).getId());
	}
	
	@Test
	public void testAfficherUneCategorie() {
		Categorie maCategorie=categorieDao.afficherUneCategorie(1);
			
		Assert.assertEquals("Categorie 1", maCategorie.getNomCategorie());
	}
	
	@Test
	public void testListePremiereImage() throws Exception{
		List<Image> listePremiereImage=categorieDao.listePremiereImage();
		
		Assert.assertEquals(3, listePremiereImage.size());
		
		Assert.assertEquals(1, listePremiereImage.get(0).getId());
		Assert.assertEquals(1, listePremiereImage.get(0).getIdCategorieImage());
		Assert.assertEquals("lienversmaphoto1.jpg", listePremiereImage.get(0).getLienImage());
		Assert.assertEquals(2, listePremiereImage.get(1).getId());
		Assert.assertEquals(4, listePremiereImage.get(2).getId());
		
	}
	
	@Test
	public void testAjoutCategorie() throws Exception{
		Categorie newCategorie= new Categorie ("Categorie 4");
		categorieDao.ajoutCategorie(newCategorie);
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM `categoriephotos` WHERE nomCategorie='Categorie 4'");
		ResultSet rs1 = stmt1.executeQuery();
	
		Assert.assertTrue(rs1.next());
		Assert.assertFalse(rs1.next());
	}
	
	@Test
	public void testModifierCategorie() throws Exception{
		categorieDao.modifierCategorie(2,"Ce n'est plus la catégorie 2");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM categoriephotos WHERE id=2");
		ResultSet rs1 = stmt1.executeQuery();
		
		Assert.assertTrue(rs1.next());
		Assert.assertEquals("Ce n'est plus la catégorie 2",rs1.getString("nomCategorie"));
		
		Assert.assertFalse(rs1.next());
	}
	
	@Test
	public void testSupprimerCategorie() throws Exception{
		categorieDao.supprimerCategorie(1);
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM categoriephotos WHERE id=1");
		ResultSet rs1 = stmt1.executeQuery();
		
		
		Assert.assertFalse(rs1.next());	
	}
}
