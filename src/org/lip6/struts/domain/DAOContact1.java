package org.lip6.struts.domain;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOContact1 {
private final static String RESOURCE_JDBC = "java:comp/env/jdbc/mydb";
    

    public String addContact(/*final long id, */final String firstName, final String lastName, final String email) {
        try {
            Context lContext = new InitialContext();
            DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            Connection lConnection  = lDataSource.getConnection();
            System.out.println("DAO addContact email : "+ email);
            // adding a new contact
            PreparedStatement lPreparedStatementCreation = 
            		lConnection.prepareStatement
            		("INSERT INTO contact(FIRSTNAME, LASTNAME, EMAIL) VALUES( ?, ?, ?)");//ID_CONTACT et ?,
            
            /*lPreparedStatementCreation.setLong(1, id);*/
            lPreparedStatementCreation.setString(1, firstName);
            lPreparedStatementCreation.setString(2, lastName);
            lPreparedStatementCreation.setString(3, email);
            lPreparedStatementCreation.executeUpdate();
            return null;
        } catch (NamingException e) {
        
            return "NamingException : " + e.getMessage();
        
        } catch (SQLException e) {

            return "SQLException : " + e.getMessage(); 
        }
    }

	public List<Contact1> getListContacts(){
		List<Contact1>lescontacts = new ArrayList<Contact1>();
		try {
	        Context lContext = new InitialContext();
	        DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
	        Connection lConnection  = lDataSource.getConnection();
			ResultSet rs=lConnection.createStatement().executeQuery("SELECT * from contact");
			
			while (rs.next()) {
				int id = rs.getInt("ID_CONTACT");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				Contact1 contact = new Contact1(id, lastname, firstname, email);
				lescontacts.add(contact);
				System.out.println("contact de la BDD : "+ contact.getId());
			}
			lConnection.close();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return lescontacts;
	}
	
    public String updateContact(long id, String firstName, String lastName, String email) {
        try {
            Context lContext = new InitialContext();
            DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            Connection lConnection  = lDataSource.getConnection();
            // updating a new contact
			int i=lConnection.createStatement().executeUpdate("UPDATE contact SET LASTNAME='" + lastName + "', FIRSTNAME='" 
			+ firstName + "', EMAIL='" + email + "' WHERE ID_contact ='"+id+"'");
			System.out.println(" DAO UPDATE --> Nombre de ligne(s) modifiée(s) dans la BDD: " + i);
            return null;
        } catch (NamingException e) {
            return "NamingException : " + e.getMessage();
        } catch (SQLException e) {
            return "SQLException : " + e.getMessage();
        }
    }
    
    public Contact1 displayContact(int idcontact) throws NamingException, SQLException {

		System.out.println("DAO DISPLAY CLIENT : " + idcontact);
		Contact1 contact = new Contact1();
        Context lContext = new InitialContext();
		DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
        Connection lConnection  = lDataSource.getConnection();
		try {
			final PreparedStatement lPreparedStatementcontact = lConnection.prepareStatement("SELECT ID_contact, LASTNAME, FIRSTNAME, EMAIL FROM contact WHERE ID_contact=?");
			lPreparedStatementcontact.setLong(1, idcontact);
			
			ResultSet rscontact = lPreparedStatementcontact.executeQuery();
			
			while (rscontact.next()) {
				final int id = rscontact.getInt("ID_contact");
				final String lastName = rscontact.getString("LASTNAME");
				final String firstName = rscontact.getString("FIRSTNAME");
				final String email = rscontact.getString("EMAIL");
				contact= new Contact1(id,lastName,firstName, email);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally{
			try {
				if(lConnection!=null) {
					lConnection.close();
				}
					
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contact;
	}
    public int deleteContact(long id) throws SQLException,Exception {
        int i=0;
        try {
            final Context lContext = new InitialContext();
            final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
            final Connection lConnection  = lDataSource.getConnection();
            // deleting a new contact
            final PreparedStatement lPreparedStatementDelete =  
                    lConnection.prepareStatement("DELETE FROM contact WHERE ID_contact="+id);
            i=lPreparedStatementDelete.executeUpdate();
            return i;
             
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
    }
    }
    
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
}
