package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mr.dao.UtilisateurDao;
import mr.entities.Utilisateur;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UtilisateurDaoTest {
	
	UtilisateurDao utilisateurDao=new UtilisateurDaoImp();
	
	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM utilisateur");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`email`, `motDePasse`, `nom`, `prenom`, `dateDeNaissance`, `rang`, `ecole`) VALUES ('romain.soenen@hei.fr','romain1993','soenen','romain','1993-03-12','administrateur','HEI')");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`email`, `motDePasse`, `nom`, `prenom`, `dateDeNaissance`, `rang`, `ecole`) VALUES ('michel.guignier@hei.fr','michel1993','guignier','michel','1993-04-30','super administrateur','HEI')");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`email`, `motDePasse`, `nom`, `prenom`, `dateDeNaissance`, `rang`, `ecole`) VALUES ('henri.malos@isa.fr','henri1993','malos','henri','1995-10-02','membre','ISA')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListeUtilisateur() {
		List<Utilisateur> listeUtilisateur=utilisateurDao.afficherListeUtilisateur();
		
		Assert.assertEquals(3, listeUtilisateur.size());
		
		Assert.assertEquals("malos", listeUtilisateur.get(0).getNom());
		Assert.assertEquals("michel", listeUtilisateur.get(1).getPrenom());
		Assert.assertEquals("romain.soenen@hei.fr", listeUtilisateur.get(2).getMail());
		
	}
	
	@Test
	public void testAjouterUtilisateur() throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateNaissanceString = "1993-03-12";
		
		Date dateNaissance = (Date) formatter.parse(dateNaissanceString);
		
		java.sql.Date datenaissanceSQL= new java.sql.Date(dateNaissance.getTime());
		Utilisateur utilisateur= new Utilisateur("florian.dupond@isen.fr","florian1995","dupond","florian",datenaissanceSQL,"membre","ISEN");
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
	public void testSupprimerUtilisateur() throws Exception{
		utilisateurDao.supprimerUtilisateur("henri.malos@isa.fr");
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM utilisateur WHERE email=?");
		stmt.setString(1, "henri.malos@isa.fr");
		ResultSet rs = stmt.executeQuery();
		
		Assert.assertFalse(rs.next());
	}
	
	@Test
	public void testAuthentificationUtilisateur(){
		Boolean rep=utilisateurDao.authentificationUtilisateur(new Utilisateur("florian.dupond@isen.fr","florian1995"));
		Assert.assertEquals(true, rep);
		
		Boolean rep1=utilisateurDao.authentificationUtilisateur(new Utilisateur("florian@dupond@isen.fr","Florian1995"));
		Assert.assertEquals(false, rep);
	}
	
}
