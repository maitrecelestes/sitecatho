package mr.dao;

import java.util.List;

import mr.entities.Contact;

public interface ContactDao {
	public List<Contact> listeMessageContact();
	public void ajouterContact (Contact contact);
	public void supprimerContact (int idContact);
}
