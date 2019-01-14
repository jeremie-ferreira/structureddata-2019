package com.epita.structureddata.converter.domain;

public class Station {
	private Integer codeUic;
	private String libelleGare;
	private Boolean fret;
	private Boolean voyageurs;
	private Integer codeLigne;
	private Integer rang;
	private Integer pk;
	private String commune;
	private String departement;
	private Integer idreseau;
	private String idgaia;
	private Double lat;
	private Double lon;
	public Integer getCodeUic() {
		return codeUic;
	}
	public void setCodeUic(Integer codeUic) {
		this.codeUic = codeUic;
	}
	public String getLibelleGare() {
		return libelleGare;
	}
	public void setLibelleGare(String libelleGare) {
		this.libelleGare = libelleGare;
	}
	public Boolean getFret() {
		return fret;
	}
	public void setFret(Boolean fret) {
		this.fret = fret;
	}
	public Boolean getVoyageurs() {
		return voyageurs;
	}
	public void setVoyageurs(Boolean voyageurs) {
		this.voyageurs = voyageurs;
	}
	public Integer getCodeLigne() {
		return codeLigne;
	}
	public void setCodeLigne(Integer codeLigne) {
		this.codeLigne = codeLigne;
	}
	public Integer getRang() {
		return rang;
	}
	public void setRang(Integer rang) {
		this.rang = rang;
	}
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public Integer getIdreseau() {
		return idreseau;
	}
	public void setIdreseau(Integer idreseau) {
		this.idreseau = idreseau;
	}
	public String getIdgaia() {
		return idgaia;
	}
	public void setIdgaia(String idgaia) {
		this.idgaia = idgaia;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	
}
