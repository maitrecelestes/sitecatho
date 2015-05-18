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
		/*stmt.executeUpdate("DELETE FROM article");
		stmt.executeUpdate("INSERT INTO `article`(`mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`, `ipPosteur`, `titre`, `archive`) VALUES ('michel.guignier@hei.fr',NOW(),'contenu article 0','Antenne Inge',true,false,'ip0','Titre article 0',false)");
		stmt.executeUpdate("INSERT INTO `article`(`mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`, `ipPosteur`, `titre`, `archive`) VALUES ('romain.soenen@hei.fr',NOW(),'contenu article 1','Bureau',true,false,'ip1','Titre article 1',false)");
		stmt.executeUpdate("INSERT INTO `article`(`mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`, `ipPosteur`, `titre`, `archive`) VALUES ('michel.guignier@hei.fr',NOW(),'contenu article 2','Antenne Inge',true,false,'ip2','Titre article 2',false)");
		*/
		stmt.close();
		connection.close();
	}
	
	/*
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
		Article nouvelleArticle=new Article("nouveau contenu", "nouveau titre", "nouveaumail@hei.fr", "Bureau", true, false);
		articleDao.ajouterArticle(nouvelleArticle, "new ip");
		
		List<Article> listeArticleBureau=articleDao.listeArticlePage("Bureau");
		
		Assert.assertEquals(2, listeArticleBureau.size());
		
		Assert.assertEquals("nouveau contenu", listeArticleBureau.get(1).getContenu());
		Assert.assertEquals("nouveaumail@hei.fr", listeArticleBureau.get(1).getMailAuteur());
		
	}
	
	/*@Test
	public void testArchiverArticle() {
		articleDao.archiverArticle(168);
		
		List<Article> listeArticleAntenne=articleDao.listeArticlePage("Antenne Inge");
		
		Assert.assertEquals(2, listeArticleAntenne.size());
		
		Assert.assertEquals(true, listeArticleAntenne.get(0).getArchive());
		Assert.assertEquals(false, listeArticleAntenne.get(1).getArchive());
	}
	*/
	
	@Test
	public void testCacherArticle() {
		articleDao.cacherArticle(168);
		
		List<Article> listeArticleAntenne=articleDao.listeArticlePage("Antenne Inge");
		
		Assert.assertEquals(2, listeArticleAntenne.size());
		
		/*Assert.assertEquals(true, listeArticleAntenne.get(0).getVisiblePage());
		Assert.assertEquals(false, listeArticleAntenne.get(1).getVisiblePage());*/
	}
	
	/*@Test
	public void testModifierArticle() throws Exception{
		Article articleModifier=new Article("modifcontenu", "modiftitre", "modifmail@hei.fr", "Bureau", true, false);
		articleDao.modifierArticle(167,articleModifier, "new ip");		
	}*/
	
}
