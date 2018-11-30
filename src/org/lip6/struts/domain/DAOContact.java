package org.lip6.struts.domain;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

public class DAOContact {
	public void addContact(/*String firstName, String lastName, String email, String street, String city, String zip, String country*/) {
		Session session = null;
		
		// creation d'un contact et son insertion dans la BD
		
		// dans le cas d'une startegie de generation de cle "increment" par exp,
		// cette ligne peut être omise
		// car l'id sera affecté automatiquement comme max des id + 1 (de la
		// table contact)
		// contact.setId(1);
		
		Contact contact = new Contact();
		
		contact.setContact_ID(1);
		contact.setPrenom("lastName");
		contact.setNom("firstName");
		contact.setMail("email");
		
		//Address address = new Address(1,street,city,zip,country);
		
		//contact.setAddress(address);

		//PhoneNumber phone = new PhoneNumber();
		//phone.setPhone_ID(12);
		//phone.setPhoneNumber("073949383");
		//phone.setContact(contact);
		
		//ContactGroup groupe = new ContactGroup();
		//groupe.setGroup_ID(1);
		//groupe.setGroupName("M2C");
		//groupe.setContact(contact);
		
		//Entreprise entreprise = new Entreprise(22,"bon","ae","bon.ae@gmail.com",address1,362521879);
		
		try {
			
			// utilisation de la classe utilitaire HibernateUtil
			// qui applique le pattern singleton et
			// qui assure que SessionFactory ne sera instanciee qu'une seule
			// fois

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			// mettre les actions entre une transaction
			org.hibernate.Transaction tx = session.beginTransaction();
			
			//session.save(address);
			//session.save(address1);
			session.save(contact);
			//session.save(phone);
			//session.save(groupe);
			//session.save(entreprise);
			
			// pour montrer qu'hibernate met à jour systematiquement la base de
			// données
			// et sans faire un save à nouveau
			//contact.setNom("TOTOTOTO");
			
			System.out.println("before Commit instruction");
			// Commiter la transaction sinon rien ne se passe
			tx.commit();

			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}
	public void displayContact() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			org.hibernate.Transaction tx = session.beginTransaction();
			
			StringBuffer requests = new StringBuffer();
			requests.append("select contact from Contact contact");
			Query request = session.createQuery( requests.toString() );
			List results = request.list();
			
			Object[] firstResult = (Object[]) results.get(0);
			Contact contact = (Contact)firstResult[0];
			Address address = (Address) firstResult[1];
			
			tx.commit();
			System.out.println("LISTE ---------------> " + contact.getNom());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
