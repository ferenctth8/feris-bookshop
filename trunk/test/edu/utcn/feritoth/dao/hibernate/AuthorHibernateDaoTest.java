/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao.hibernate;

import edu.utcn.feritoth.core.Author;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 *
 * @author Feri
 */
public class AuthorHibernateDaoTest extends TestCase {
    
    public AuthorHibernateDaoTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getAllAuthors method, of class AuthorHibernateDao.
     */    
    public void testGetAllAuthors() {
        System.out.println("getAllAuthors");
        AuthorHibernateDao instance = new AuthorHibernateDao();
        List expResult = instance.getAllAuthors();
        List result = instance.getAllAuthors();
        assertFalse(expResult.equals(result));        
    }

    /**
     * Test of getMatchingAuthors method, of class AuthorHibernateDao.
     */    
    public void testGetMatchingAuthors() {
        System.out.println("getMatchingAuthors");
        String nameSequence = "F";
        AuthorHibernateDao instance = new AuthorHibernateDao();
        List expResult = instance.getMatchingAuthors(nameSequence);
        List result = instance.getMatchingAuthors(nameSequence);
        assertFalse(expResult.equals(result));        
    }

    /**
     * Test of findAuthorByID method, of class AuthorHibernateDao.
     */
    public void testFindAuthorByID() {
        System.out.println("findAuthorByID");
        int authorID = 18;
        AuthorHibernateDao instance = new AuthorHibernateDao();
        Author expResult = instance.findAuthorByID(authorID);
        Author result = instance.findAuthorByID(authorID);
        assertFalse(expResult.equals(result));        
    }

    /**
     * Test of registerNewAuthor method, of class AuthorHibernateDao.
     */
    public void testRegisterNewAuthor() {
        System.out.println("registerNewAuthor");
        String name = "Herbert George";
        String surname = "Wells";
        int birthYear = 1866;
        int deathYear = 1946;
        String shortDescription = "The founder of Science Fiction";
        String referencePage = "http://hu.wikipedia.org/wiki/H._G._Wells";
        AuthorHibernateDao instance = new AuthorHibernateDao();
        boolean expResult = true;
        boolean result = instance.registerNewAuthor(name, surname, birthYear, deathYear, shortDescription, referencePage);
        assertEquals(expResult, result);        
    }

    /**
     * Test of updateExistingAuthor method, of class AuthorHibernateDao.
     */
    public void testUpdateExistingAuthor() {
        System.out.println("updateExistingAuthor");
        int authorID = 31;
        String newDescription = "The Pioneer of Existentialism";
        AuthorHibernateDao instance = new AuthorHibernateDao();
        boolean expResult = true;
        boolean result = instance.updateExistingAuthor(authorID, newDescription);
        assertEquals(expResult, result);        
    }

    /**
     * Test of removeSelectedAuthor method, of class AuthorHibernateDao.
     */
    /*public void testRemoveSelectedAuthor() {
        System.out.println("removeSelectedAuthor");
        int authorID = 42;
        AuthorHibernateDao instance = new AuthorHibernateDao();
        boolean expResult = true;
        boolean result = instance.removeSelectedAuthor(authorID);
        assertEquals(expResult, result);       
    }*/
}
