/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao.hibernate;

import edu.utcn.feritoth.dao.AdministratorDao;
import edu.utcn.feritoth.dao.DaoFactory;

/**
 *
 * @author Feri
 */
public class HibernateDaoFactory extends DaoFactory{

    @Override
    public AdministratorDao getAdministratorDao() {
        return new AdministratorHibernateDao();
    }
    
}
