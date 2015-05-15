package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mr.dao.CategorieDao;
import mr.entities.Categorie;
import mr.entities.Image;

public class CategorieDaoImp implements CategorieDao {

	@Override
	public List<Categorie> listeCategorie() {
		Connection connection;
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `categoriephotos` ORDER BY `dateCreation` DESC ");
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Categorie categorie = new Categorie(results.getInt("id"),
						results.getString("nomCategorie"),
						results.getDate("dateCreation"));
				listeCategorie.add(categorie);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeCategorie;
	}

	@Override
	public Categorie afficherUneCategorie(int idCategorie) {
		Connection connection;
		Categorie categorie = null;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt1 = connection
					.prepareStatement("SELECT * FROM `categoriephotos` WHERE `id`=?");
			stmt1.setInt(1, idCategorie);
			ResultSet results = stmt1.executeQuery();
			while (results.next()) {
				categorie = new Categorie(idCategorie,
						results.getString("nomCategorie"),
						results.getDate("dateCreation"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}

	@Override
	public void ajoutCategorie(Categorie nomCategorie) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `categoriephotos`(`nomCategorie`, `dateCreation`) VALUES (?,NOW())");
			stmt.setString(1, nomCategorie.getNomCategorie());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifierCategorie(int idCategorie, String newNomCategorie) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE `categoriephotos` SET `nomCategorie`=? WHERE id=?");
			stmt.setString(1, newNomCategorie);
			stmt.setInt(2, idCategorie);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerCategorie(int idCategorie) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM `categoriephotos` WHERE id=?");
			stmt.setInt(1, idCategorie);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Image> listePremiereImage() {
		Connection connection;
		CategorieDao categorieDao = new CategorieDaoImp();
		List<Categorie> listeCategorie = categorieDao.listeCategorie();
		List<Image> listeImage = new ArrayList<Image>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			for (int i = 0; i < listeCategorie.size(); i++) {
				PreparedStatement stmt = connection
						.prepareStatement("SELECT * FROM `photo` WHERE IdCategoriePhoto=? ORDER BY `dateCreation` DESC LIMIT 1");
				stmt.setInt(1, listeCategorie.get(i).getId());
				ResultSet results = stmt.executeQuery();
				Image image = null;
				while (results.next()) {
					image = new Image(results.getInt("id"),
							results.getString("lienPhoto"),
							results.getString("mailAuteur"),
							results.getInt("idCategoriePhoto"),
							results.getDate("dateCreation"));

				}
				listeImage.add(image);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeImage;

	}

}
