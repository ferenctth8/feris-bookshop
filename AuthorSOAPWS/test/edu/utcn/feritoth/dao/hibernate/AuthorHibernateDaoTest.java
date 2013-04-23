/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao.hibernate;

import edu.utcn.feritoth.core.Author;
import java.util.List;
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
        //given 
        System.out.println("getAllAuthors");
        AuthorHibernateDao instance = new AuthorHibernateDao();
        
        //when 
        List<Author> result = instance.getAllAuthors();
        
        //then
        assertEquals(result.size(), 42);
        assertEquals("Herbert George Wells", result.get(40).getName());       
    }

    /**
     * Test of getMatchingAuthors method, of class AuthorHibernateDao.
     */    
    public void testGetMatchingAuthors() {
        //given
        System.out.println("getMatchingAuthors");
        String nameSequence = "F";
        AuthorHibernateDao instance = new AuthorHibernateDao();
        
        //when
        List<Author> result = instance.getMatchingAuthors(nameSequence);
        
        //then
        assertEquals(result.size(), 8);      
        for (Author author:result){
            System.out.println(author.toString() + "\n");        
        }
    }

    /**
     * Test of findAuthorByID method, of class AuthorHibernateDao.
     */
    public void testFindAuthorByID() {
        //given
        System.out.println("findAuthorByID");
        int authorID = 18;
        AuthorHibernateDao instance = new AuthorHibernateDao();
        
        //when
        Author result = instance.findAuthorByID(authorID);
        
        //then
        assertEquals("Maksim Gorky", result.getName());        
    }

    /**
     * Test of registerNewAuthor method, of class AuthorHibernateDao.
     */
    public void testRegisterNewAuthor() {
        //given
        /*System.out.println("registerNewAuthor");        
        String name = "James Fenimore";
        String surname = "Cooper";
        int birthYear = 1789;
        int deathYear = 1851;
        String shortDescription = "One of the most popular american novelists";
        String referencePage = "http://en.wikipedia.org/wiki/James_Fenimore_Cooper";
        AuthorHibernateDao instance = new AuthorHibernateDao();
        boolean expResult = true;
        
        //when
        boolean result = instance.registerNewAuthor(name, surname, birthYear, deathYear, shortDescription, referencePage);
        
        //then
        assertEquals(expResult, result);*/        
    }

    /**
     * Test of updateExistingAuthor method, of class AuthorHibernateDao.
     */
    public void testUpdateExistingAuthor() {
        //given
        /*System.out.println("updateExistingAuthor");
        int authorID = 31;
        String newDescription = "";
        AuthorHibernateDao instance = new AuthorHibernateDao();
        boolean expResult = true;
        
        //when        
        boolean result = instance.updateExistingAuthor(authorID, newDescription);
        
        //then
        assertEquals(expResult, result);*/        
    }

    /**
     * Test of removeSelectedAuthor method, of class AuthorHibernateDao.
     */
    public void testRemoveSelectedAuthor() {
        //given       
        /*System.out.println("removeSelectedAuthor");
        int authorID = 43;
        AuthorHibernateDao instance = new AuthorHibernateDao();
        boolean expResult = true;
        
        //when
        boolean result = instance.removeSelectedAuthor(authorID);
        
        //then 
        assertEquals(expResult, result);*/       
    }
}
