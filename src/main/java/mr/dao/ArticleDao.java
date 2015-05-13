package mr.dao;

import java.util.List;

import mr.entities.Article;

public interface ArticleDao {
	
	public List<Article> listeArticlePage(String nomPage);
	
	public Article unArticle(int id);
	
	public void ajouterArticle (Article newArticle, String IP);
	
	public void archiverArticle (int numeroArticle);
	
	public void cacherArticle (int numeroArticle);
	
	public void modifierArticle(int numeroArticle,Article articlemodifier, String IP);

	public void modifierPageArticle(String nompageprecedenteModif, String nompageModif);
		
}
