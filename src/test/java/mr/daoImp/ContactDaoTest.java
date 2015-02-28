package mr.daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import mr.dao.ContactDao;
import mr.entities.Contact;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class ContactDaoTest {
	private ContactDao contactDao = new ContactDaoImp();
	
	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM contact");
		stmt.executeUpdate("INSERT INTO `contact`(`idMessage`, `nom`, `prenom`, `mail`, `objet`, `contenu`, `ipPosteur`, `datePoste`) VALUES (1,'Guignier','Michel','michel.guignier@hei.fr','Mon binome est trop fort','Je voudrais changer de binome car je le miens est trop fort pour moi','ip michel',NOW())");
		stmt.executeUpdate("INSERT INTO `contact`(`idMessage`, `nom`, `prenom`, `mail`, `objet`, `contenu`, `ipPosteur`, `datePoste`) VALUES (2,'Soenen','Romain','romain.soenen@hei.fr','Mon binome est mécrant','Michel ne fait que de dire des bêtises','ip romain',NOW())");
		stmt.executeUpdate("INSERT INTO `contact`(`idMessage`, `nom`, `prenom`, `mail`, `objet`, `contenu`, `ipPosteur`, `datePoste`) VALUES (3,'Gouvy','Nicolas','lapinou@hotmail.fr','Stop','Arrêtez votre cirque','ip nicolas',NOW())");
		stmt.close();
		connection.close();
	}
	
	
	@Test
	public void testListeContact() {
		List<Contact> listeMessageContact=contactDao.listeMessageContact();
		
		Assert.assertEquals(3, listeMessageContact.size());
		
		Assert.assertEquals("Je voudrais changer de binome car je le miens est trop fort pour moi", listeMessageContact.get(0).getContenu());
		Assert.assertEquals("ip michel", listeMessageContact.get(0).getIpPosteur());
		Assert.assertEquals("Soenen", listeMessageContact.get(1).getNom());
		Assert.assertEquals("romain.soenen@hei.fr", listeMessageContact.get(1).getMail());
		Assert.assertEquals("Nicolas", listeMessageContact.get(2).getPrenom());
		Assert.assertEquals("Stop", listeMessageContact.get(2).getObjet());
	}
	
	@Test
	public void testAjouterContact() throws Exception{
		Contact newContact= new Contact ("Bernard", "Nicolas","bernic@wanadoo.fr" ,"Coucou", "C'est pas mon projet mais je viens dire bonjour", "ip Nicolas");
		contactDao.ajouterContact(newContact);
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM contact ORDER BY datePoste DESC, idMessage DESC");
		ResultSet rs1 = stmt1.executeQuery();
	
		Assert.assertTrue(rs1.next());
		Assert.assertEquals(newContact.getContenu(),rs1.getString("contenu"));
		Assert.assertEquals(newContact.getPrenom(),rs1.getString("prenom"));
		Assert.assertEquals(newContact.getIpPosteur(),rs1.getString("ipPosteur"));
		Assert.assertTrue(rs1.next());
	}
	
	public void testSuppresionContact() throws Exception{
		contactDao.supprimerContact(2);
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM contact ORDER BY idMessage ASC");
		ResultSet rs1 = stmt1.executeQuery();
		
		Assert.assertTrue(rs1.next());
		Assert.assertEquals("Je voudrais changer de binome car je le miens est trop fort pour moi",rs1.getString("contenu"));
		Assert.assertEquals("Michel",rs1.getString("prenom"));
		Assert.assertEquals("ip michel",rs1.getString("ipPosteur"));
		
		Assert.assertTrue(rs1.next());
		Assert.assertEquals("Soenen",rs1.getString("nom"));
		Assert.assertEquals("Mon binome est mécrant",rs1.getString("objet"));
		
		Assert.assertTrue(rs1.next());
	}
}
