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
		Connection connection;
		List<Article> listeArticle= new ArrayList<Article>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("SELECT * FROM `article` WHERE `page`=? ORDER BY `dateCreation` DESC ");
			stmt.setString(1, nomPage); 
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Article article= new Article(results.getString("contenu"),results.getString("titre"),results.getString("mailAuteur"), results.getDate("dateCreation"),results.getString("page"),
						results.getBoolean("visibilitePage"),results.getBoolean("description_de_page"));
				listeArticle.add(article);
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticle;
		
	}

	@Override
	public void ajouterArticle(Article newArticle, String IP) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("INSERT INTO `article`(`numeroArticle`, titre, `mailAuteur`, `dateCreation`, `contenu`, `page`, `visibilitePage`, `description_de_page`,`ipPosteur`) VALUES (?,?,?,NOW(),?,?,?,?,?)");
			stmt.setInt(1,trouverNumeroArticleLibre());
			stmt.setString(2, newArticle.getTitre());
			stmt.setString(3, newArticle.getMailAuteur());
			stmt.setString(4, newArticle.getContenu()); 
			stmt.setString(5, newArticle.getPage());
			stmt.setBoolean(6,newArticle.getVisiblePage());
			stmt.setBoolean(7,newArticle.getArticleDescription());
			stmt.setString(8,IP);
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

	@Override
	public void modifierArticle(int numeroArticle, Article articlemodifier, String IP) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("INSERT INTO `editionarticle`(`idArticle`, `ipAuteur`, `dateEdition`, `mailAuteur`) VALUES (?,?,NOW(),?)");
			stmt.setInt(1,numeroArticle); 
			stmt.setString(2, IP);
			stmt.setString(3, "test@test.fr");
			stmt.executeUpdate();
			
			PreparedStatement stmt1= connection.prepareStatement("UPDATE `article` SET `contenu`=?,`visibilitePage`=?,`description_de_page`=?,`titre`=? WHERE `numeroArticle`=?");
			stmt1.setString(1,articlemodifier.getContenu()); 
			stmt1.setBoolean(2, articlemodifier.getVisiblePage());
			stmt1.setBoolean(3, articlemodifier.getArticleDescription());
			stmt1.setString(4, articlemodifier.getTitre());
			stmt1.setInt(5,numeroArticle); 
			stmt1.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public int trouverNumeroArticleLibre() {
		int rep=0;
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("SELECT numeroArticle FROM `article` ORDER BY `numeroArticle` ASC ");
			ResultSet results = stmt.executeQuery();
			int compteur=0;
			while (results.next()&& rep==0) {
				compteur = compteur+1;
				if(compteur!=results.getInt("numeroArticle")){
					rep= compteur;
				}
			}
			if (rep==0){
				rep= compteur+1;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rep;
	}
	
	
	
}
