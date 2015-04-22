package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mr.dao.ImageDao;
import mr.entities.Image;

public class ImageDaoImp implements ImageDao{

	@Override
	public void ajouterImage(Image addimage,String ipPosteur) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("INSERT INTO `photo`(`lienPhoto`,`categoriePhotos`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES (?,?,?,NOW(),?)");
			stmt.setString(1, addimage.getLienImage());
			stmt.setString(2, addimage.getCategorieImage());
			stmt.setString(3, addimage.getMailPosteur());
			stmt.setString(4, ipPosteur);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
