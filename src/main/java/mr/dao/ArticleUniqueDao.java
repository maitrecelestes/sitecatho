package mr.dao;

import mr.entities.ArticleUnique;

public interface ArticleUniqueDao {

	public void modifierArticle(String nomPage,
			ArticleUnique monNouvelArticleUnique, String IP);

	public ArticleUnique listeArticleUnique(String nomPage);

}
