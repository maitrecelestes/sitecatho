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
	public List<Utilisateur> afficherListeDeTousLesUtilisateur() {
		Connection connection;
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `utilisateur` ORDER BY `email` ASC ");
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Utilisateur utilisateur = new Utilisateur(
						results.getString("email"),
						results.getInt("idUtilisateur"),
						results.getString("motDePasse"),
						results.getString("nom"), results.getString("prenom"),
						results.getString("rang"), results.getString("ecole"),
						results.getString("pageGere"));
				listeUtilisateur.add(utilisateur);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateur;
	}

	@Override
	public List<Utilisateur> afficherListeUtilisateurNonArchive() {
		Connection connection;
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `utilisateur` WHERE `archive`=false AND `email`='Super Administrateur' ORDER BY `email` ASC ");
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Utilisateur utilisateur = new Utilisateur(
						results.getString("email"),
						results.getInt("idUtilisateur"),
						results.getString("motDePasse"),
						results.getString("nom"), results.getString("prenom"),
						results.getString("rang"), results.getString("ecole"),
						results.getString("pageGere"));
				listeUtilisateur.add(utilisateur);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `utilisateur` WHERE `email`<>'Super Administrateur' AND `archive`=false AND `rang`='administrateur' ORDER BY `email` ASC");
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Utilisateur utilisateur = new Utilisateur(
						results.getString("email"),
						results.getInt("idUtilisateur"),
						results.getString("motDePasse"),
						results.getString("nom"), results.getString("prenom"),
						results.getString("rang"), results.getString("ecole"),
						results.getString("pageGere"));
				listeUtilisateur.add(utilisateur);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `utilisateur` WHERE `archive`=false AND `rang`='redacteur' ORDER BY `email` ASC ");
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Utilisateur utilisateur = new Utilisateur(
						results.getString("email"),
						results.getInt("idUtilisateur"),
						results.getString("motDePasse"),
						results.getString("nom"), results.getString("prenom"),
						results.getString("rang"), results.getString("ecole"),
						results.getString("pageGere"));
				listeUtilisateur.add(utilisateur);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateur;
	}

	public Utilisateur afficherUtilisateur(String login) {
		Connection connection;
		Utilisateur utilisateur = null;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `utilisateur` WHERE email=? ORDER BY `email` ASC ");
			stmt.setString(1, login);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				utilisateur = new Utilisateur(results.getString("email"),
						results.getInt("idUtilisateur"),
						results.getString("motDePasse"),
						results.getString("nom"), results.getString("prenom"),
						results.getString("rang"), results.getString("ecole"),
						results.getString("pageGere"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public String HashMyPassword(String password) throws Exception {
		// On crypte le password en MD5 avec un salt le tout 3 fois
		password = "3637" + password + "cathoaumonerie59";
		for (int a = 0; a < 3; a++) {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}

			password = sb.toString();
		}

		return password;

	}

	@Override
	public void ajouterUtilisateur(Utilisateur newUtilisateur) {
		Connection connection;
		try {
			String mdpnonCrypte = newUtilisateur.getMdp();
			String mdpCrypte = HashMyPassword(mdpnonCrypte);

			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `utilisateur`(`email`, `motDePasse`, `nom`, `prenom`, `rang`, `ecole`, `pageGere`, `archive`) VALUES (?,?,?,?,?,?,?,false)");
			stmt.setString(1, newUtilisateur.getMail());
			stmt.setString(2, mdpCrypte);
			stmt.setString(3, newUtilisateur.getNom());
			stmt.setString(4, newUtilisateur.getPrenom());
			stmt.setString(5, newUtilisateur.getRang());
			stmt.setString(6, newUtilisateur.getEcole());
			stmt.setString(7, newUtilisateur.getPageGere());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerUtilisateur(String mail) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE `utilisateur` SET `archive`=true WHERE `email`=?");
			stmt.setString(1, mail);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void modifierUtilisateur(String mail, String rang, String ecole,
			String gerePage, String mdp) throws Exception {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt;
			if (mdp == null){
				stmt = connection
						.prepareStatement("UPDATE `utilisateur` SET rang=?, ecole=?, pageGere=? WHERE email=?");
				stmt.setString(1, rang);
				stmt.setString(2, ecole);
				stmt.setString(3, gerePage);
				stmt.setString(4, mail);
			} else {
				stmt = connection
						.prepareStatement("UPDATE `utilisateur` SET rang=?, ecole=?, pageGere=?, motDePasse=? WHERE email=?");
				stmt.setString(1, rang);
				stmt.setString(2, ecole);
				stmt.setString(3, gerePage);
				stmt.setString(4, HashMyPassword(mdp));
				stmt.setString(5, mail);
			}
			
			
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean authentificationUtilisateur(Utilisateur utilisateur) {
		Connection connection;
		Boolean rep = false;
		try {
			String mdpnonCrypte = utilisateur.getMdp();
			String mdpCrypte = HashMyPassword(mdpnonCrypte);

			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT motDePasse FROM `utilisateur` WHERE `email`=? AND `archive`=false");
			stmt.setString(1, utilisateur.getMail());
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				if (mdpCrypte.equals(results.getString("motDePasse"))) {
					rep = true;
				}
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rep;
	}

	@Override
	public void remplacementUtilisateur(Utilisateur newUtilisateur) {
		Connection connection;
		try {
			String mdpnonCrypte = newUtilisateur.getMdp();
			String mdpCrypte = HashMyPassword(mdpnonCrypte);

			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE `utilisateur` SET `motDePasse`=?,`nom`=?,`prenom`=?,`rang`=?,`ecole`=?,`pageGere`=?,`archive`=false WHERE `email`=?");
			stmt.setString(1, mdpCrypte);
			stmt.setString(2, newUtilisateur.getNom());
			stmt.setString(3, newUtilisateur.getPrenom());
			stmt.setString(4, newUtilisateur.getRang());
			stmt.setString(5, newUtilisateur.getEcole());
			stmt.setString(6, newUtilisateur.getPageGere());
			stmt.setString(7, newUtilisateur.getMail());

			stmt.executeUpdate();
			connection.close();
		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
