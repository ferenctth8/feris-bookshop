/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao;

import edu.utcn.feritoth.dao.hibernate.HibernateDaoFactory;

/**
 *
 * @author Feri
 */
public abstract class DaoFactory {
    
    /**
     * The abstract class DaoFactory is the one responsible for the management
     * of the connection between the database and the program itself.It is the
     * basis serving for the usage of the Singleton design pattern.
     */
    /**
     * The first factory method from the current class is responsible for
     * creating a new instance of the HibernateDaoFactory responsible for database
     * connection performance and in the meantime it replaces an explicit class
     * constructor as well.
     *
     * @return a new instance of HibernateDaoFactory class
     */
    public static DaoFactory getInstance() {
        return new HibernateDaoFactory();
    }

    /**
     * The abstract method getAdministratorDao() is in charge of dealing with the
     * database table for the Administrators
     *
     * @return the AdministratorDao reference object
     */
    public abstract AdministratorDao getAdministratorDao();
    
}
