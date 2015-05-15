package mr.dao;

import mr.entities.PhotoEntete;

public interface PhotoEnteteDao {
	public PhotoEntete afficherPhotoEntete(String Page);

	public void ajouterNouvellePhoto(PhotoEntete maNouvellePhoto, String IP,
			String mailPosteur);
}
