package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mr.dao.PhotoEnteteDao;
import mr.entities.PhotoEntete;

public class PhotoEnteteDaoImp implements PhotoEnteteDao{

	@Override
	public PhotoEntete afficherPhotoEntete(String Page) {
		Connection connection;
		PhotoEntete maPhotoEntete=null;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("SELECT `LienPhoto`, `PagePhoto` FROM `photoentete` WHERE `PagePhoto`=?");
			stmt.setString(1, Page); 
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				maPhotoEntete=new PhotoEntete(results.getString("LienPhoto"),results.getString("PagePhoto"));
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maPhotoEntete;
	}

	@Override
	public void ajouterNouvellePhoto(PhotoEntete maNouvellePhoto) {
		// TODO Auto-generated method stub
		
	}

}
