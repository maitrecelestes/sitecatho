package mr.entities;

public class PhotoEntete {
	private String lienPhoto;
	private String pagePhoto;
	
	public PhotoEntete(String lienPhoto, String pagePhoto){
		this.lienPhoto=lienPhoto;
		this.pagePhoto=pagePhoto;
	}

	public String getLienPhoto() {
		return lienPhoto;
	}

	public String getPagePhoto() {
		return pagePhoto;
	}
	
}
