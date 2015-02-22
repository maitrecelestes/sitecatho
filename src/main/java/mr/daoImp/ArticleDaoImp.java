package mr.daoImp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mr.dao.ArticleDao;
import mr.entities.Article;

public class ArticleDaoImp implements ArticleDao{
	
	public List<Article> listeArticlePage(String nomPage){
		Connection connection;//
		List<Article> listeArticle= new ArrayList<Article>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("SELECT * FROM `article` WHERE `page`=? ORDER BY `dateCreation` DESC ");
			stmt.setString(1, nomPage); 
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Article article= new Article(results.getString("contenu"),results.getString("mailAuteur"), results.getDate("dateCreation"),results.getString("page"),
						results.getBoolean("visibilitePage"),results.getBoolean("Description de page"));
				listeArticle.add(article);
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeArticle;
		
	}

	@Override
	public void ajouterArticle(Article newArticle) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("INSERT INTO `article`(`numeroArticle`, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `Description de page`) VALUES (?,?,NOW(),?,?,?,?)");
			stmt.setInt(1,5); //A MODIFIER
			stmt.setString(2, newArticle.getMailAuteur());
			stmt.setString(3, newArticle.getContenu()); 
			stmt.setString(4, newArticle.getPage());
			stmt.setBoolean(5,newArticle.getVisiblePage());
			stmt.setBoolean(6,newArticle.getArticleDescription());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerArticle(int numeroArticle) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("DELETE FROM `article` WHERE numeroArticle =?");
			stmt.setInt(1,numeroArticle); 
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
