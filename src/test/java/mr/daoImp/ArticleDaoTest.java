package mr.daoImp;


import java.sql.Connection;
import java.sql.Date;
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
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`,titre, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `Description de page`,ipPosteur) VALUES (1,'Article chat','loveoiseau@test.fr',NOW(),'Le ciel est bleu et le chat chante','Antenne',true,false,'ip1')");
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`,titre, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `Description de page`,ipPosteur) VALUES (2,'Article poney','loveponey@test.fr',NOW(),'Le ciel est bleu et les poneys gambadent','Antenne',true,false,'ip2')");
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`,titre, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `Description de page`,ipPosteur) VALUES (3,'Article poney rose','loveponey@test.fr',NOW(),'Vive les poneyes roses','Poney',true,false,'ip3')");
		stmt.close();
		connection.close();
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
		articleDao.ajouterArticle(nouvelleArticle);
		
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
}
