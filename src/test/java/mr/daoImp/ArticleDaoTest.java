package mr.daoImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import mr.dao.ArticleDao;
import mr.entities.Article;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticleDaoTest {
	private ArticleDao articleDao = new ArticleDaoImp();
	
	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM article");
		stmt.executeUpdate("DELETE FROM editionArticle");
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`,titre, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`,ipPosteur) VALUES (1,'Article chat','loveoiseau@test.fr',NOW(),'Le ciel est bleu et le chat chante','Antenne',true,false,'ip1')");
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`,titre, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`,ipPosteur) VALUES (2,'Article poney','loveponey@test.fr',NOW(),'Le ciel est bleu et les poneys gambadent','Antenne',true,false,'ip2')");
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`,titre, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`,ipPosteur) VALUES (3,'Article poney rose','loveponey@test.fr',NOW(),'Vive les poneyes roses','Poney',true,false,'ip3')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testrouverNumeroArticleLibre() {
		int rep1 = articleDao.trouverNumeroArticleLibre();
		Assert.assertEquals(4,rep1);
	}
	
	@Test
	public void testListeArticlePage() {
		List<Article> listeArticleAntenne=articleDao.listeArticlePage("Antenne");
		List<Article> listeArticlePoney=articleDao.listeArticlePage("Poney");
		
		Assert.assertEquals(2, listeArticleAntenne.size());
		Assert.assertEquals(1, listeArticlePoney.size());
		
		Assert.assertEquals("Le ciel est bleu et le chat chante", listeArticleAntenne.get(0).getContenu());
		Assert.assertEquals("Vive les poneyes roses", listeArticlePoney.get(0).getContenu());
		
		Assert.assertEquals("loveponey@test.fr", listeArticleAntenne.get(1).getMailAuteur());
		
	}
	
	@Test
	public void testAjouterArticle() {
		Article nouvelleArticle=new Article("Les poney arrivent","Pro-titre", "cmichel@love.fr", null,"Banane", true, false);
		articleDao.ajouterArticle(nouvelleArticle, "new ip");
		
		List<Article> listeArticleBanane=articleDao.listeArticlePage("Banane");
		
		Assert.assertEquals(1, listeArticleBanane.size());
		
		Assert.assertEquals("Les poney arrivent", listeArticleBanane.get(0).getContenu());
		Assert.assertEquals("cmichel@love.fr", listeArticleBanane.get(0).getMailAuteur());
		
	}
	
	@Test
	public void testSupprimerArticle() {
		articleDao.supprimerArticle(1);
		
		List<Article> listeArticleAntenne=articleDao.listeArticlePage("Antenne");
		
		Assert.assertEquals(1, listeArticleAntenne.size());
		
		Assert.assertEquals("Le ciel est bleu et les poneys gambadent", listeArticleAntenne.get(0).getContenu());
		Assert.assertEquals("loveponey@test.fr", listeArticleAntenne.get(0).getMailAuteur());
	}
	
	@Test
	public void testModifierArticle() throws Exception{
		Article articleModifier=new Article("Les poney arrivent plus vite que prévu","Un vrai titre", "cmichel@love.fr", null,"Banane", true, false);
		
		articleDao.modifierArticle(2,articleModifier, "new ip");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM article WHERE numeroArticle=2");
		ResultSet rs1 = stmt1.executeQuery();
		
		Assert.assertTrue(rs1.next());
		Assert.assertEquals(articleModifier.getContenu(),rs1.getString("contenu"));
		Assert.assertEquals(articleModifier.getTitre(),rs1.getString("titre"));
		
		PreparedStatement stmt2 = connection.prepareStatement("SELECT * FROM editionarticle WHERE idArticle=2");
		ResultSet rs2 = stmt2.executeQuery();
		
		
		Assert.assertTrue(rs2.next());
		Assert.assertEquals(2,rs2.getInt("idArticle"));
		Assert.assertEquals("new ip",rs2.getString("ipAuteur"));
		
	}
	
}
