/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao.hibernate;

import edu.utcn.feritoth.core.Administrator;
import edu.utcn.feritoth.dao.AdministratorDao;
import edu.utcn.feritoth.utils.AdministratorHibernateUtil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Feri
 */
public class AdministratorHibernateDao implements AdministratorDao{

    protected AdministratorHibernateDao(){
    
    }
    
    private String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }   
    
    private Session createNewSession() {
        Session session = AdministratorHibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }    
    
    @Override
    public List<Administrator> getAllAdmins() {
        Session currentSession = createNewSession();
        List<Administrator> administratorList = null;
        Transaction tx = currentSession.beginTransaction();
        try {
            tx.begin();
            Query q = currentSession.createQuery("from Administrator");
            administratorList = (List<Administrator>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return administratorList;
    }

    @Override
    public Administrator getMatchingAdmin(String emailAddress, String passcode) {
        Administrator matchingAdministrator = null;
        Session currentSession = createNewSession();
        Transaction tx = currentSession.beginTransaction();
        try {
            tx.begin();           
            String encryptionResult = getMD5(passcode);
            Query q = currentSession.createQuery("from Administrator as administrator where administrator.emailAddress='" + emailAddress + "' and administrator.passcode='" + encryptionResult+"'");
            matchingAdministrator = (Administrator) q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return matchingAdministrator;
    }

    @Override
    public Administrator findAdministratorByID(int adminID) {
        Administrator selectedAdministrator = null;
        Session currentSession = createNewSession();
        Transaction tx = currentSession.beginTransaction();
        try {
            tx.begin();
            Query q = currentSession.createQuery("from Administrator as administrator where administrator.administratorId=" + adminID);
            selectedAdministrator = (Administrator) q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return selectedAdministrator;
    }
    
    
    
    
    
}
