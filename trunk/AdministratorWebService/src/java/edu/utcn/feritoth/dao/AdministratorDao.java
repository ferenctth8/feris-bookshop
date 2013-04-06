/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao;

import edu.utcn.feritoth.core.Administrator;
import java.util.List;

/**
 *
 * @author Feri
 */
public interface AdministratorDao {
    
    /**
     * The current method retrieves the list of all administrators.
     * @return the list of all administrators
     */
    List<Administrator> getAllAdmins();
    
    /**
     * The current method returns the administrator whose credentials are given as parameter.
     * @param emailAddress - the emailAddress of the administrator in question
     * @param passcode - the password of the administrator 
     * @return the administrator with the matching credentials or a null reference
     */
    Administrator getMatchingAdmin(String emailAddress, String passcode);
    
    /**
     * The current method returns an administrator on the basis of the ID given as parameter.
     * @param adminID - the ID to be looked up
     * @return the matching Administrator or null for no match
     */
    Administrator findAdministratorByID(int adminID);
    
}
