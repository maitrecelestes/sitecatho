package mr.entities;


public class Menu {
	private Integer idpage;
	private String nompage;
	private Integer rang;
	/*private Boolean visibilite;*/
	
	public Menu(Integer idpage, String nompage, Integer rang/*, Boolean visibilite*/) {
		super();
		this.idpage = idpage;
		this.nompage = nompage;
		this.rang = rang;
		/*this.visibilite = visibilite;*/
	}

	public Integer getIdpage() {
		return idpage;
	}

	public void setIdpage(Integer idpage) {
		this.idpage = idpage;
	}

	public String getNompage() {
		return nompage;
	}

	public void setNompage(String nompage) {
		this.nompage = nompage;
	}

	public Integer getRang() {
		return rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
	}

	/*public Boolean getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(Boolean visibilite) {
		this.visibilite = visibilite;
	}*/

		
}
