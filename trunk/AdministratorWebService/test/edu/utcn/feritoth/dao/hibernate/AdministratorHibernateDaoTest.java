/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao.hibernate;

import edu.utcn.feritoth.core.Administrator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Feri
 */
public class AdministratorHibernateDaoTest {
    
    public AdministratorHibernateDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllAdmins method, of class AdministratorHibernateDao.
     */
    @Test
    public void testGetAllAdmins() {
        System.out.println("getAllAdmins");
        AdministratorHibernateDao instance = new AdministratorHibernateDao();
        List expResult = instance.getAllAdmins();
        List result = instance.getAllAdmins();
        assertFalse(expResult.equals(result));       
    }

    /**
     * Test of getMatchingAdmin method, of class AdministratorHibernateDao.
     */
    @Test
    public void testGetMatchingAdmin() {
        System.out.println("getMatchingAdmin");
        String emailAddress = "ferenctth8@gmail.com";
        String passcode = "0743560248";
        AdministratorHibernateDao instance = new AdministratorHibernateDao();
        Administrator expResult = instance.getMatchingAdmin(emailAddress, passcode);
        Administrator result = instance.getMatchingAdmin(emailAddress, passcode);
        assertFalse(expResult.equals(result));        
    }

    /**
     * Test of findAdministratorByID method, of class AdministratorHibernateDao.
     */
    @Test
    public void testFindAdministratorByID() {
        System.out.println("findAdministratorByID");
        int adminID = 3;
        AdministratorHibernateDao instance = new AdministratorHibernateDao();
        Administrator expResult = instance.findAdministratorByID(adminID);
        Administrator result = instance.findAdministratorByID(adminID);
        assertFalse(expResult.equals(result));        
    }
}
