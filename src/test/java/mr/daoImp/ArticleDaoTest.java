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
		stmt.executeUpdate("INSERT INTO `article`(`mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`, `ipPosteur`, `titre`, `archive`) VALUES ('michel.guignier@hei.fr',NOW(),'contenu article 0','Antenne Inge',true,false,'ip0','Titre article 0',false)");
		stmt.executeUpdate("INSERT INTO `article`(`mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`, `ipPosteur`, `titre`, `archive`) VALUES ('romain.soenen@hei.fr',NOW(),'contenu article 1','Bureau',true,false,'ip1','Titre article 1',false)");
		stmt.executeUpdate("INSERT INTO `article`(`mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`, `ipPosteur`, `titre`, `archive`) VALUES ('michel.guignier@hei.fr',NOW(),'contenu article 2','Antenne Inge',true,false,'ip2','Titre article 2',false)");
		
		stmt.close();
		connection.close();
	}
	
	/*@Test
	public void testrouverNumeroArticleLibre() {
		int rep1 = articleDao.trouverNumeroArticleLibre();
		Assert.assertEquals(4,rep1);
	}*/
	
	@Test
	public void testListeArticlePage() {
		List<Article> listeArticleAntenne=articleDao.listeArticlePage("Antenne Inge");
		List<Article> listeArticleBureau=articleDao.listeArticlePage("Bureau");
		
		Assert.assertEquals(2, listeArticleAntenne.size());
		Assert.assertEquals(1, listeArticleBureau.size());
		Assert.assertEquals("contenu article 0", listeArticleAntenne.get(0).getContenu());
		Assert.assertEquals("contenu article 1", listeArticleBureau.get(0).getContenu());
		Assert.assertEquals("michel.guignier@hei.fr", listeArticleAntenne.get(1).getMailAuteur());
		
	}
	
	@Test
	public void testAjouterArticle() {
	//	Article nouvelleArticle=new Article("nouveau contenu", "nouveau titre", "nouveaumail@hei.fr", "Bureau", true, false);
	//	articleDao.ajouterArticle(nouvelleArticle, "new ip");
		
		/*List<Article> listeArticleBureau=articleDao.listeArticlePage("Bureau");
		
		Assert.assertEquals(2, listeArticleBureau.size());
		
		Assert.assertEquals("nouveau contenu", listeArticleBureau.get(1).getContenu());
		Assert.assertEquals("nouveaumail@hei.fr", listeArticleBureau.get(1).getMailAuteur());
		*/
	}
	/*
	@Test
	public void testSupprimerArticle() {
		articleDao.supprimerArticle(1);
		
		List<Article> listeArticleAntenne=articleDao.listeArticlePage("Antenne Inge");
		
		Assert.assertEquals(1, listeArticleAntenne.size());
		
		Assert.assertEquals("Le ciel est bleu et les poneys gambadent", listeArticleAntenne.get(0).getContenu());
		Assert.assertEquals("loveponey@test.fr", listeArticleAntenne.get(0).getMailAuteur());
	}
	
	@Test
	public void testModifierArticle() throws Exception{
		Article articleModifier=new Article("Les poney arrivent plus vite que prévu","Un vrai titre", "cmichel@love.fr", null,"Banane", true, false,false);
		
		articleDao.modifierArticle(2,articleModifier, "new ip");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM article WHERE idArticle=2");
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
	*/
}
