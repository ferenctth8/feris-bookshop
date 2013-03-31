/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao.hibernate;

import edu.utcn.feritoth.core.Author;
import edu.utcn.feritoth.dao.AuthorDao;
import edu.utcn.feritoth.utils.AuthorHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Feri
 */
public class AuthorHibernateDao implements AuthorDao {

    protected AuthorHibernateDao(){
    
    }
    
    private Session createNewSession() {
        Session session = AuthorHibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }

    @Override
    public List<Author> getAllAuthors() {
        Session currentSession = createNewSession();
        List<Author> authorList = null;
        Transaction tx = currentSession.beginTransaction();
        try {
            tx.begin();
            Query q = currentSession.createQuery("from Author");
            authorList = (List<Author>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return authorList;
    }

    @Override
    public List<Author> getMatchingAuthors(String nameSequence) {
        Session currentSession = createNewSession();
        List<Author> authorList = null;
        Transaction tx = currentSession.beginTransaction();
        try {
            tx.begin();
            Query q = currentSession.createQuery("from Author as author where author.name like'%" + nameSequence + "%'");
            authorList = (List<Author>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return authorList;
    }

    @Override
    public Author findAuthorByID(int authorID) {
        Author selectedAuthor = null;
        Session currentSession = createNewSession();
        Transaction tx = currentSession.beginTransaction();
        try {
            tx.begin();
            Query q = currentSession.createQuery("from Author as author where author.authorId=" + authorID);
            selectedAuthor = (Author) q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return selectedAuthor;
    }

    @Override
    public boolean registerNewAuthor(String name, String surname, int birthYear, int deathYear, String shortDescription, String referencePage) {
        //create a new author, session and transaction context for the operation in question
        Author newAuthor = new Author();
        Session currentSession = createNewSession();
        Transaction tx = currentSession.beginTransaction();
        try {
            //create the author and set its details
            //also verify data integrity for problematic fields
            tx.begin();           
            String authorName = name + " " +surname;
            String portraitFile = surname + ".png";
            String yearsOfLife = null;
            if (1000 <= birthYear && birthYear <= 9999 && 1000 <= deathYear && deathYear <= 9999) {
                yearsOfLife = birthYear + "-" + deathYear;
            }            
            boolean refOK = referencePage.startsWith("http://");
            boolean descOK1 = (shortDescription != null) ? true : false;
            boolean descOK2 = (shortDescription.length() > 0) ? true : false;
            if (refOK && descOK1 && descOK2 && yearsOfLife != null) {                            
                newAuthor.setName(authorName);
                newAuthor.setYearsOfLife(yearsOfLife);
                newAuthor.setShortDescription(shortDescription);
                newAuthor.setReference(referencePage);
                newAuthor.setImage(portraitFile);                
                currentSession.save(newAuthor);
                tx.commit();
            }           
            return true;
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
            return false;
        }        
    }

    @Override
    public boolean updateExistingAuthor(int authorID, String newDescription) {
        //create a new session and a new transaction 
        Session currentSession = createNewSession();
        Transaction tx = currentSession.beginTransaction();
        //execute the transaction in question
        try {
            tx.begin();
            Query q = currentSession.createQuery("from Author as author where author.authorId=" + authorID);          
            Author selectedAuthor = (Author) q.uniqueResult();
            boolean descOK1 = (newDescription != null) ? true : false;
            boolean descOK2 = (newDescription.length() > 0) ? true : false;
            if (selectedAuthor != null && descOK1 && descOK2) {
                selectedAuthor.setShortDescription(newDescription);
                currentSession.update(selectedAuthor);
                tx.commit();
            }
        } catch (Exception e) {
            //for any exceptions which might occur, rollback the transaction if possible and list the cause
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeSelectedAuthor(int authorID) {
        //create a new session and transaction
        Session currentSession = createNewSession();
        Transaction tx = currentSession.beginTransaction();
        //execute the transaction in question        
        try {            
            tx.begin();
            Query q = currentSession.createQuery("from Author as author where author.authorId=" + authorID);
            Author removedAuthor = (Author) q.uniqueResult(); 
            currentSession.delete(removedAuthor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
