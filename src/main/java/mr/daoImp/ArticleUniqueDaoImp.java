package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mr.dao.ArticleUniqueDao;
import mr.entities.ArticleUnique;

public class ArticleUniqueDaoImp implements ArticleUniqueDao {

	@Override
	public void modifierArticle(String nomPage, ArticleUnique articlemodifier,
			String IP) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE `articleunique` SET `mailAuteur`=?,`dateCreation`=NOW(),`contenu`=?,`ipPosteur`=?,`titre`=? WHERE `nomPage`=?");
			stmt.setString(1, articlemodifier.getMailAuteur());
			stmt.setString(2, articlemodifier.getContenu());
			stmt.setString(3, IP);
			stmt.setString(4, articlemodifier.getTitre());
			stmt.setString(5, nomPage);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArticleUnique listeArticleUnique(String nomPage) {
		Connection connection;
		ArticleUnique listeArticle = null;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `articleunique` WHERE `nomPage`=? ORDER BY `dateCreation` DESC ");
			stmt.setString(1, nomPage);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				listeArticle = new ArticleUnique(results.getString("nomPage"),
						results.getString("mailAuteur"),
						results.getDate("dateCreation"),
						results.getString("contenu"),
						results.getString("titre"));
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticle;
	}

}
