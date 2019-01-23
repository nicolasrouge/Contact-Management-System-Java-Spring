package org.lip6.struts.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lip6.struts.domain.Contact;
import util.HibernateUtil;

public class DAOContact {
	
	private SessionFactory sessionFactory;
	
	public DAOContact()
	{
		
	}
	
	public DAOContact(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addContact(String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country) {
		
		Session session = null;
		
		boolean res = false;
		
		// creation d'un contact et son insertion dans la BD
		
		Contact newcontact = new Contact();
		
		newcontact.setContact_ID(1);
		newcontact.setPrenom(lastName);
		newcontact.setNom(firstName);
		newcontact.setMail(email);
		
		Address newaddress = new Address(1,street,city,zip,country);
		
		newcontact.setAddress(newaddress);

		PhoneNumber newphone = new PhoneNumber();
		newphone.setPhone_ID(12);
		newphone.setPhoneNumber(phonenumber);
		newphone.setContact(newcontact);
		
		try {
			
			/*sessionFactory.getCurrentSession().save(newaddress);
			sessionFactory.getCurrentSession().save(newcontact);
			sessionFactory.getCurrentSession().save(newphone);*/
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();

			// mettre les actions entre une transaction
			org.hibernate.Transaction tx = session.beginTransaction();
			System.out.print("DAO ADD " + newcontact.getNom());
			
			session.save(newaddress);
			session.save(newcontact);
			session.save(newphone);
			tx.commit();
			
			System.out.println("Done");
			res = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return res;

	}
	
	public Contact getContact(long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		       
		      Contact c = (Contact) session.load(Contact.class, id);
		      System.out.println("GET CONTACT" + c.getPrenom() + " --------------- ");
		       
		      //Let's verify the entity name
		      System.out.println(session.getEntityName(c));
		       
		      session.getTransaction().commit();
			return c;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<PhoneNumber> getPhones(long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      
		      Query q = session.createQuery("select pN from PhoneNumber pN where pN.id = :id");
		      q.setParameter("id", id);
		      @SuppressWarnings("unchecked")
			List<PhoneNumber> list = q.list();
		      
		      //Contact c = (Contact) session.load(Contact.class, id);
		      //System.out.println("GET CONTACT" + c.getPrenom() + " --------------- ");
		       
		      //Let's verify the entity name
		      //System.out.println(session.getEntityName(c));
		       
		      session.getTransaction().commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addGroup(String nomGroup) {
		Session session = null;
		ContactGroup group = new ContactGroup();

		group.setGroup_ID(1);
		group.setGroupName(nomGroup);
		
		//créer un contact au préalable
		//group.setContact(contact);
		
		try {
			
			// utilisation de la classe utilitaire HibernateUtil
			// qui applique le pattern singleton et
			// qui assure que SessionFactory ne sera instanciee qu'une seule fois
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();

			// mettre les actions entre une transaction
			org.hibernate.Transaction tx = session.beginTransaction();
			
			session.save(group);
			
			// pour montrer qu'hibernate met à jour systematiquement la base de données
			// et sans faire un save à nouveau
			//contact.setNom("TOTOTOTO");
			
			System.out.println("before Commit instruction");
			// Commiter la transaction sinon rien ne se passe
			tx.commit();

			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return true;

	}
	
	public List<Contact> getListContacts() {
		List<Contact> lesContacts = new ArrayList<Contact>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			StringBuffer requestS = new StringBuffer();
			requestS.append("select contact from Contact contact");
			Query request = session.createQuery(requestS.toString());
			
			@SuppressWarnings("unchecked")
			List<Contact> list = request.list();
			//on récupère chaque contact de la requête et on les mets dans la liste 'lescontacts'
			for(Contact contact : list) {
				Contact c = new Contact(contact);
				c.setContact_ID(contact.getContact_ID());
				lesContacts.add(c);
			}
			
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
	}
		return lesContacts;
	}
	
	public List<ContactGroup> getListGroup(){
		List<ContactGroup> lesGroupes = new ArrayList<ContactGroup>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			StringBuffer requestS = new StringBuffer();
			requestS.append("select contactGroup from ContactGroup contactGroup");
			System.out.println("DAO GROUP request"+requestS.toString());
			Query request = session.createQuery(requestS.toString());
			
			List<ContactGroup> list = request.list();
			for(ContactGroup group : list) {
				ContactGroup groupe = new ContactGroup();
				groupe.setGroup_ID(group.getGroup_ID());
				groupe.setGroupName(group.getGroupName());
				lesGroupes.add(groupe);
				System.out.println("DAO GROUP "+group.getGroupName());
			}
			
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
	}
		return lesGroupes;
}
	
	public boolean deleteContact(long id) {
    	boolean res = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			//Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
			Contact contact = (Contact) session.get(Contact.class, id);
			System.out.println("DELETE :" + contact.getMail());
			session.delete(contact);
			session.getTransaction().commit();
			session.close();
			//sessionFactory.getCurrentSession().delete(contact);
			res = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean updateContact(long id, String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country){
	    try {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Contact contact = (Contact) session.get(Contact.class, id);
			System.out.println("UPDATE :" + contact.getMail());
			
			contact.setMail(email);
			contact.setNom(lastName);
			contact.setPrenom(firstName);
			//TODO Phone NUMBER
			contact.getAddress().setCity(city);
			contact.getAddress().setCountry(country);
			contact.getAddress().setStreet(street);
			contact.getAddress().setZip(zip);
			
			session.update(contact);
			session.getTransaction().commit();
			session.close();
	    } catch (Exception e) {
	        return true;
	    }
	    return false;
	}
	
	/*
    public List<Contact1> searchContact(String word) throws NamingException, SQLException {
		System.out.println("Entre dans search contact DAO");
		List<Contact1>contacts = new ArrayList<Contact1>();
        Context lContext = new InitialContext();
        DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
        Connection lConnection  = lDataSource.getConnection();
		try {
			final PreparedStatement lPreparedStatementContact = lConnection.prepareStatement("SELECT ID_CONTACT, LASTNAME, FIRSTNAME, EMAIL FROM contact WHERE ID_CONTACT LIKE ? OR LASTNAME LIKE ? OR FIRSTNAME LIKE ? OR EMAIL LIKE ?");
			lPreparedStatementContact.setString(1, "%" + word + "%");
			lPreparedStatementContact.setString(2, "%" + word + "%");
			lPreparedStatementContact.setString(3, "%" + word + "%");
			lPreparedStatementContact.setString(4, "%" + word + "%");
			ResultSet rsContact = lPreparedStatementContact.executeQuery();

			while (rsContact.next()) {

				final Long id = rsContact.getLong("ID_CONTACT");
				final String lastName = rsContact.getString("LASTNAME");
				final String firstName = rsContact.getString("FIRSTNAME");
				final String email = rsContact.getString("EMAIL");

				contacts.add(new Contact1(id, lastName, firstName, email));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally{
			try {
				if(lConnection!=null) {
					lConnection.close();
					//return ArrayList;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contacts;
    	}
	*/
	public void generate() {
		addContact("Nicolas", "Rouge", "nicolas.rouge@gmail.com", "0750474601","rue des olives","Nanterre", "92000", "France");
		addContact("Lucas", "Nayet", "lucas.nayet@gmail.com", "0634261733","rue du puit","Nanterre", "92000", "France");
	}

	public List<Contact> searchContact(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	
}