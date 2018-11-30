package org.lip6.struts.domain;

public class Entreprise extends Contact{
	private long num_siret;
	
	public Entreprise() {
		super();
	}
	
	public Entreprise(long contact_ID, String nom, String prenom, String mail, Address address, long num_siret) {
		super(contact_ID, nom, prenom, mail, address);
		this.num_siret = num_siret;
	}
	
	public long getNum_siret() {
		return num_siret;
	}

	public void setNum_siret(long num_siret) {
		this.num_siret = num_siret;
	}	
}
