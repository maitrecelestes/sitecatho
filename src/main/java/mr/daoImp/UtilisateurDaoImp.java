package mr.daoImp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mr.dao.UtilisateurDao;
import mr.entities.Utilisateur;

public class UtilisateurDaoImp implements UtilisateurDao {
	
	@Override
	public List<Utilisateur> afficherListeUtilisateur() {
		Connection connection;
		List<Utilisateur> listeUtilisateur= new ArrayList<Utilisateur>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("SELECT * FROM `utilisateur` ORDER BY `email` ASC ");
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Utilisateur utilisateur= new Utilisateur(results.getString("email"),results.getString("motDePasse"),results.getString("nom"),results.getString("prenom"), results.getDate("dateDeNaissance"),results.getString("rang"),results.getString("ecole"));
				listeUtilisateur.add(utilisateur);
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateur;
	}
	
	public String crypteMdp(String mdp) throws NoSuchAlgorithmException{
		String mdp1=mdp+"un peu de sel";
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(mdp1.getBytes());
		byte[] mdpdigest = md.digest();
		
		String mdpCrypte1= mdpdigest.toString()+"un peu De poiVre 25%";
		MessageDigest md1 = MessageDigest.getInstance("SHA-1");
		md1.update(mdpCrypte1.getBytes());
		byte[] mdpdigest1 = md.digest();
		
		String mdpCrypte2= mdpdigest1.toString();
		return mdpCrypte2;
	}
	
	@Override
	public void ajouterUtilisateur(Utilisateur newUtilisateur) {
		Connection connection;
		try {
			String mdpnonCrypte=newUtilisateur.getMdp();
			String mdpCrypte=crypteMdp(mdpnonCrypte);
			
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("INSERT INTO `utilisateur`(`email`, `motDePasse`, `nom`, `prenom`, `dateDeNaissance`, `rang`, `ecole`) VALUES (?,?,?,?,?,?,?)");
			stmt.setString(1, newUtilisateur.getMail());
			stmt.setString(2, mdpCrypte);
			stmt.setString(3, newUtilisateur.getNom()); 
			stmt.setString(4, newUtilisateur.getPrenom());
			stmt.setDate(5,newUtilisateur.getDateDeNaissance());
			stmt.setString(6,newUtilisateur.getRang());
			stmt.setString(7,newUtilisateur.getEcole());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerUtilisateur(String mail) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("DELETE FROM `utilisateur` WHERE email=?");
			stmt.setString(1,mail); 
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public boolean authentificationUtilisateur(Utilisateur utilisateur) {
		Connection connection;
		Boolean rep=false;
		try {
			String mdpnonCrypte=utilisateur.getMdp();
			String mdpCrypte=crypteMdp(mdpnonCrypte);
			
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("SELECT motDePasse FROM `utilisateur` WHERE `email`=? ");
			stmt.setString(1,utilisateur.getMail()); 
			ResultSet results = stmt.executeQuery();
			while(results.next()){
				System.out.println(results.getString("motDePasse"));
				if(mdpCrypte==results.getString("motDePasse")){
					rep=true;
				}
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}

	

}
