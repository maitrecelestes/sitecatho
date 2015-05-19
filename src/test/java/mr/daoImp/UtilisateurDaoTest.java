package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import mr.dao.UtilisateurDao;
import mr.entities.Utilisateur;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UtilisateurDaoTest {
	
	UtilisateurDao utilisateurDao=new UtilisateurDaoImp();
	
	@Before //INITIALISATION DE LA BDD POUR LE TEST
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM utilisateur"); 
		stmt.executeUpdate("INSERT INTO `utilisateur`(`email`,idUtilisateur, `motDePasse`, `nom`, "
				+ "`prenom`, `rang`, `ecole`,archive) VALUES ('romain.soenen@hei.fr',1,'romain1993','soenen',"
				+ "'romain','administrateur','HEI',false)");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`email`,idUtilisateur, `motDePasse`, `nom`, `prenom`, `rang`, `ecole`,archive) VALUES ('michel.guignier@hei.fr',2,'michel1993','guignier','michel','redacteur','HEI',false)");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`email`,idUtilisateur, `motDePasse`, `nom`, `prenom`, `rang`, `ecole`,archive) VALUES ('henri.malos@isa.fr',3,'henri1993','malos','henri','redacteur','ISA',false)");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`email`,idUtilisateur, `motDePasse`, `nom`, `prenom`, `rang`, `ecole`,archive) VALUES ('Super Administrateur',4,'17650c6f6ad033803e905af4ab4854dd','Administrateur','Super','administrateur','HEI',false)");
		stmt.close();
		connection.close();
	}
	
	@Test //TEST POUR LA FONCTION afficherListeUtilisateurNonArchive()
	public void testListeUtilisateur() {
		List<Utilisateur> listeUtilisateur=utilisateurDao.afficherListeUtilisateurNonArchive();
		
		Assert.assertEquals(4, listeUtilisateur.size()); //ON VERIFIE LE NOMBRE D'UTILISATEUR DANS LA LISTE
		
		Assert.assertEquals("malos", listeUtilisateur.get(0).getNom()); //ON VERIFIE A CERTAINS ENDROIT QUE LA VALEUR
																		// ATTENDUE CORREPOND A LA VALEUR REEL
		Assert.assertEquals("michel", listeUtilisateur.get(1).getPrenom());
		Assert.assertEquals("romain.soenen@hei.fr", listeUtilisateur.get(2).getMail());
		
	}
	
	@Test
	public void testUtilisateur() {
		Utilisateur utilisateur=utilisateurDao.afficherUtilisateur("romain.soenen@hei.fr");
		Assert.assertEquals("soenen", utilisateur.getNom());
		Assert.assertEquals("romain", utilisateur.getPrenom());
	
		
	}
	
	@Test
	public void testAjouterUtilisateur() throws Exception{
		
		Utilisateur utilisateur= new Utilisateur("florian.dupond@isen.fr","florian1995","dupond","florian","membre","ISEN",null);
		utilisateurDao.ajouterUtilisateur(utilisateur);
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM utilisateur WHERE email=?");
		stmt.setString(1, utilisateur.getMail());
		ResultSet rs = stmt.executeQuery();
			
		Assert.assertTrue(rs.next());
		Assert.assertEquals(utilisateur.getNom(), rs.getString("nom"));
		Assert.assertEquals(utilisateur.getRang(), rs.getString("rang"));
		Assert.assertEquals(utilisateur.getEcole(), rs.getString("ecole"));
		Assert.assertFalse(rs.next());
	}
	
	@Test
	public void testmodifierUtilisateur() throws Exception{
		utilisateurDao.modifierUtilisateur("henri.malos@isa.fr","admin","hei","","");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM utilisateur WHERE email=?");
		stmt.setString(1, "henri.malos@isa.fr");
		ResultSet rs = stmt.executeQuery();
		
		Assert.assertTrue(rs.next());
		Assert.assertEquals("admin", rs.getString("rang"));
	}
	
	@Test
	public void testSupprimerUtilisateur() throws Exception{
		utilisateurDao.supprimerUtilisateur("henri.malos@isa.fr");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM utilisateur WHERE email=? AND archive=false");
		stmt.setString(1, "henri.malos@isa.fr");
		ResultSet rs = stmt.executeQuery();
		
		Assert.assertFalse(rs.next());
	}
	
	@Test
	public void testAuthentificationUtilisateur() throws ParseException{
	
		Utilisateur utilisateur= new Utilisateur("florian.dupond@isen.fr","florian1995","dupond","florian","membre","ISEN",null);
		utilisateurDao.ajouterUtilisateur(utilisateur);
		
		Boolean rep=utilisateurDao.authentificationUtilisateur(new Utilisateur("florian.dupond@isen.fr","florian1995"));
		Assert.assertEquals(true, rep);
		
		Boolean rep1=utilisateurDao.authentificationUtilisateur(new Utilisateur("florian@dupond@isen.fr","Dlorian1995"));
		Assert.assertEquals(false, rep1);
	}
	
}
