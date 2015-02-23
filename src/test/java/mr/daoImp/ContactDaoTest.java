package mr.daoImp;

import java.sql.Connection;
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
		stmt.executeUpdate("INSERT INTO `contact`(`idMessage`, `nom`, `prenom`, `objet`, `contenu`, `ipPosteur`, `datePoste`) VALUES (1,'Guignier','Michel','Mon binome est trop fort','Je voudrais changer de binome car je le miens est trop fort pour moi','ip michel',NOW())");
		stmt.executeUpdate("INSERT INTO `contact`(`idMessage`, `nom`, `prenom`, `objet`, `contenu`, `ipPosteur`, `datePoste`) VALUES (2,'Soenen','Romain','Mon binome est mécrant','Michel ne fait que de dire des bêtises','ip romain',NOW())");
		stmt.executeUpdate("INSERT INTO `contact`(`idMessage`, `nom`, `prenom`, `objet`, `contenu`, `ipPosteur`, `datePoste`) VALUES (3,'Gouvy','Nicolas','Stop','Arrêtez votre cirque','ip nicolas',NOW())");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListeArticlePage() {
		List<Contact> listeMessageContact=contactDao.listeMessageContact();
		
		Assert.assertEquals(3, listeMessageContact.size());
		
		Assert.assertEquals("Je voudrais changer de binome car je le miens est trop fort pour moi", listeMessageContact.get(0).getContenu());
		Assert.assertEquals("ip michel", listeMessageContact.get(0).getIpPosteur());
		Assert.assertEquals("Soenen", listeMessageContact.get(1).getNom());
		Assert.assertEquals("Nicolas", listeMessageContact.get(2).getPrenom());
		Assert.assertEquals("Stop", listeMessageContact.get(2).getObjet());
	
	}
}
