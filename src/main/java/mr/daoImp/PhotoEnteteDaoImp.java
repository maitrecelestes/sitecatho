package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mr.dao.PhotoEnteteDao;
import mr.entities.PhotoEntete;

public class PhotoEnteteDaoImp implements PhotoEnteteDao {

	@Override
	public PhotoEntete afficherPhotoEntete(String Page) {
		Connection connection;
		PhotoEntete maPhotoEntete = null;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT `LienPhoto`, `PagePhoto` FROM `photoentete` WHERE `PagePhoto`=?");
			stmt.setString(1, Page);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				maPhotoEntete = new PhotoEntete(results.getString("LienPhoto"),
						results.getString("PagePhoto"));
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maPhotoEntete;
	}

	@Override
	public void ajouterNouvellePhoto(PhotoEntete maNouvellePhoto, String IP,
			String mailPosteur) {
		Connection connection;
		PhotoEnteteDao photoEnteteDao = new PhotoEnteteDaoImp();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();

			PhotoEntete testPresence = photoEnteteDao
					.afficherPhotoEntete(maNouvellePhoto.getPagePhoto());
			if (testPresence == null) {
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO `photoentete`(`LienPhoto`, `PagePhoto`, `IpPosteur`, `mailPosteur`, `datePoste`) VALUES (?,?,?,?,NOW())");
				stmt.setString(1, maNouvellePhoto.getLienPhoto());
				stmt.setString(2, maNouvellePhoto.getPagePhoto());
				stmt.setString(3, IP);
				stmt.setString(4, mailPosteur);
				stmt.executeUpdate();
			} else {
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE `photoentete` SET `LienPhoto`=?,`IpPosteur`=?,`mailPosteur`=?,`datePoste`=NOW() WHERE `PagePhoto`=?");
				stmt.setString(1, maNouvellePhoto.getLienPhoto());
				stmt.setString(2, IP);
				stmt.setString(3, mailPosteur);
				stmt.setString(4, maNouvellePhoto.getPagePhoto());
				stmt.executeUpdate();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
