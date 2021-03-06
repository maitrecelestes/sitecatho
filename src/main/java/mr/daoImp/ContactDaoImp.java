package mr.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mr.dao.ContactDao;
import mr.entities.Contact;

public class ContactDaoImp implements ContactDao {

	@Override
	public List<Contact> listeMessageContact() {
		Connection connection;
		List<Contact> listeContact = new ArrayList<Contact>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `contact` ORDER BY `idMessage` ASC ");
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Contact contact = new Contact(results.getInt("idMessage"),
						results.getString("nom"), results.getString("prenom"),
						results.getString("mail"), results.getString("objet"),
						results.getString("contenu"),
						results.getString("ipPosteur"),
						results.getDate("datePoste"),
						results.getTime("heurePoste"));
				listeContact.add(contact);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeContact;

	}

	@Override
	public void ajouterContact(Contact newContact) {
		Connection connection;
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `contact`(`nom`, `prenom`, `mail` ,`objet`, `contenu`, `ipPosteur`, `datePoste`, `heurePoste`) VALUES (?,?,?,?,?,?,NOW(),NOW())");
			stmt.setString(1, newContact.getNom());
			stmt.setString(2, newContact.getPrenom());
			stmt.setString(3, newContact.getMail());
			stmt.setString(4, newContact.getObjet());
			stmt.setString(5, newContact.getContenu());
			stmt.setString(6, newContact.getIpPosteur());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerContact(int idContact) {
		Connection connection;

		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM `contact` WHERE idMessage =?");
			stmt.setInt(1, idContact);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
