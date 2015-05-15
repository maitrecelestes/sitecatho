package mr.dao;

import java.util.List;

import mr.entities.Article;
import mr.entities.ArticleUnique;

public interface ArticleUniqueDao {
		
	public void modifierArticle(String nomPage,ArticleUnique monNouvelArticleUnique, String IP);
	public ArticleUnique listeArticleUnique(String nomPage);
		
}
