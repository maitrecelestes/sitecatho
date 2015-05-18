package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mr.dao.ArticleDao;
import mr.entities.Article;

public class ArticleDaoImp implements ArticleDao {

	@Override
	public List<Article> listeArticlePage(String nomPage) {
		Connection connection;
		List<Article> listeArticle = new ArrayList<Article>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `article` WHERE `page`=? ORDER BY `dateCreation` DESC ");
			stmt.setString(1, nomPage);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Article article = new Article(results.getInt("idArticle"),
						results.getString("contenu"),
						results.getString("titre"),
						results.getString("mailAuteur"),
						results.getDate("dateCreation"),
						results.getString("page"),
						results.getBoolean("visibilitePage"),
						results.getBoolean("description_de_page"),
						results.getBoolean("archive"));
				listeArticle.add(article);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticle;
	}

	@Override
	public Article unArticle(int id) {
		Connection connection;
		Article article = null;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt1 = connection
					.prepareStatement("SELECT * FROM `article` WHERE `idArticle`=?");
			stmt1.setInt(1, id);
			ResultSet results = stmt1.executeQuery();
			while (results.next()) {
				article = new Article(results.getInt("idArticle"),
						results.getString("contenu"),
						results.getString("titre"),
						results.getString("mailAuteur"),
						results.getDate("dateCreation"),
						results.getString("page"),
						results.getBoolean("visibilitePage"),
						results.getBoolean("description_de_page"),
						results.getBoolean("archive"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public void ajouterArticle(Article newArticle, String IP) {
		Connection connection;
		try { //ON ENTOURE D'UN TRY/CATCH DANS LE CAS OU IL Y AURAIT UN PROBLEME
			connection = DataSourceProvider.getDataSource().getConnection(); // ON SE CONNECTE A LA BDD
			PreparedStatement stmt = connection //ON PREPARE LA REQUETE
					.prepareStatement("INSERT INTO `article`(`mailAuteur`, `dateCreation`, `contenu`, `page`, "
							+ "`visibilitePage`, `description_de_page`, `ipPosteur`, `titre`, `archive`) "
							+ "VALUES (?,NOW(),?,?,?,?,?,?,?)");
			stmt.setString(1, newArticle.getMailAuteur()); //ON AJOUTE LES VARIABLES
			stmt.setString(2, newArticle.getContenu());
			stmt.setString(3, newArticle.getPage());
			stmt.setBoolean(4, newArticle.getVisiblePage());
			stmt.setBoolean(5, newArticle.getArticleDescription());
			stmt.setString(6, IP);
			stmt.setString(7, newArticle.getTitre());
			stmt.setBoolean(8, false);
			stmt.executeUpdate(); //ON EXECUTE LA REQUETE
			connection.close(); // ON FERME LA BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void archiverArticle(int numeroArticle) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE `article` SET `archive`=true WHERE `idArticle`=?");
			stmt.setInt(1, numeroArticle);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cacherArticle(int numeroArticle) {
		Connection connection;
		boolean visible = visibleOuNon(numeroArticle);
		if (visible) {
			try {
				connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE `article` SET `visibilitePage`=false WHERE `idArticle`=?");
				stmt.setInt(1, numeroArticle);
				stmt.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE `article` SET `visibilitePage`=true WHERE `idArticle`=?");
				stmt.setInt(1, numeroArticle);
				stmt.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean visibleOuNon(int numeroArticle) {
		Connection connection;
		boolean visible = false;
		Article article;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt1 = connection
					.prepareStatement("SELECT * FROM `article` WHERE `idArticle`=?");
			stmt1.setInt(1, numeroArticle);
			ResultSet results = stmt1.executeQuery();
			while (results.next()) {
				article = new Article(results.getInt("idArticle"),
						results.getString("contenu"),
						results.getString("titre"),
						results.getString("mailAuteur"),
						results.getDate("dateCreation"),
						results.getString("page"),
						results.getBoolean("visibilitePage"),
						results.getBoolean("description_de_page"),
						results.getBoolean("archive"));
				visible = article.getVisiblePage();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visible;
	}

	@Override
	public void modifierArticle(int numeroArticle, Article articlemodifier,
			String IP) {
		archiverArticle(numeroArticle);
		ajouterArticle(articlemodifier, IP);
	}

	@Override
	public void modifierPageArticle(String nompageprecedenteModif,
			String nompageModif) {
		Connection connection;

		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE `article` SET `page`=? WHERE `page`=?");
			stmt.setString(1, nompageModif);
			stmt.setString(2, nompageprecedenteModif);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
