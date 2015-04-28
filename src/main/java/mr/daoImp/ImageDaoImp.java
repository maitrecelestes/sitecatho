package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mr.dao.ImageDao;
import mr.entities.Image;

public class ImageDaoImp implements ImageDao{
	
	@Override
	public List<Image> listeImageCategorie(int idCategorie) {
		Connection connection;
		List<Image> listeImage= new ArrayList<Image>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("SELECT * FROM `photo` WHERE idCategoriePhoto=? ORDER BY `dateCreation` DESC ");
			stmt.setInt(1, idCategorie);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Image image= new Image(results.getInt("id"),results.getString("lienPhoto"),results.getString("mailAuteur"),results.getInt("idCategoriePhoto"),results.getDate("dateCreation"));
				listeImage.add(image);
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeImage;
	}
	
	@Override
	public void ajouterImage(Image addimage,String ipPosteur) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("INSERT INTO `photo`(`lienPhoto`,`idCategoriePhoto`, `mailAuteur`, `dateCreation`, `ipPosteur`) VALUES (?,?,?,NOW(),?)");
			stmt.setString(1, addimage.getLienImage());
			stmt.setInt(2, addimage.getIdCategorieImage());
			stmt.setString(3, addimage.getMailPosteur());
			stmt.setString(4, ipPosteur);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void supprimerUneImage(int idPhoto) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("DELETE FROM `photo` WHERE id=?");
			stmt.setInt(1,idPhoto); 
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void supprimerTouteImageCategorie(int idCategorie) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("DELETE FROM `photo` WHERE idCategoriePhoto=?");
			stmt.setInt(1,idCategorie); 
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
