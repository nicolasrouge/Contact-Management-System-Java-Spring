package org.lip6.struts.domain;

public class Entreprise extends Contact{
	private long num_siret;
	
	public Entreprise() {
		super();
	}
	
	public Entreprise(Contact contact, long num_siret) {
		super(contact);
		this.num_siret = num_siret;
	}
	
	public long getNum_siret() {
		return num_siret;
	}

	public void setNum_siret(long num_siret) {
		this.num_siret = num_siret;
	}	
}
