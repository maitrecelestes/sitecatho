package mr.daoImp;


import java.sql.Connection;
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
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `Description de page`) VALUES (1,'loveoiseau@test.fr',NOW(),'Le ciel est bleu et le chat chante','Antenne',true,false)");
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `Description de page`) VALUES (2,'loveponey@test.fr',NOW(),'Le ciel est bleu et les poneys gambadent','Antenne',true,false)");
		stmt.executeUpdate("INSERT INTO `article`(`numeroArticle`, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `Description de page`) VALUES (3,'loveponey@test.fr',NOW(),'Vive les poneyes roses','Poney',true,false)");
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
		
		Assert.assertEquals("loveoiseau@test.fr", listeArticleAntenne.get(1).getMailAuteur());
		
	}
}
