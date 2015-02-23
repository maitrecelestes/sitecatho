package mr.dao;

import java.util.List;

import mr.entities.Article;

public interface ArticleDao {
	
	public List<Article> listeArticlePage(String nomPage);
	
	public void ajouterArticle (Article newArticle, String IP);
	
	public void supprimerArticle (int numeroArticle);
	
	public void modifierArticle(int numeroArticle,Article articlemodifier, String IP);
	
	public int trouverNumeroArticleLibre();
		
}
