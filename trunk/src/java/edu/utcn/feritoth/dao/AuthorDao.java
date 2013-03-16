/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.dao;

import edu.utcn.feritoth.core.Author;
import java.util.List;

/**
 *
 * @author Feri
 */
public interface AuthorDao {
    
    /**
     * The current method retrieves the list of all authors
     * @return the list of all authors
     */
    List<Author> getAllAuthors();
    
    /**
     * The current method returns the list of all matching authors who have in their name the 
     * sequence given as parameter.
     * @param nameSequence - the sequence which is to be used for searching
     * @return the list of all matching entries or an empty list for no match
     */
    List<Author> getMatchingAuthors(String nameSequence);
    
    /**
     * The current method returns an author on the basis of the ID given as parameter
     * @param authorID - the ID to be looked up
     * @return the matching Author or null for no match
     */
    Author findAuthorByID(int authorID);    
    
    /**
     * The current method will register for us a new author in the database using the given parameters
     * @param name - the name of the author
     * @param surname - the surname of the author
     * @param birthYear - the year when the author was born
     * @param deathYear - the year when the author died
     * @param shortDescription - a brief comment about the author
     * @param referencePage - a reference page about the author
     * @return the ID of the new author or 0, depending on the success of the result
     */
    boolean registerNewAuthor(String name, String surname, int birthYear, 
                          int deathYear, String shortDescription, String referencePage);    
    
    /**
     * The current method will update for us the description of the author given as first parameter with the 
     * value given as second parameter
     * @param authorID - the author to be updated
     * @param newDescription - the new description of the author in question
     * @return a boolean value indicating the success of the operation
     */
    boolean updateExistingAuthor(int authorID, String newDescription);
    
    /**
     * The current method removes the author with the ID given as parameter
     * @param authorID - the ID of the author to be removed
     * @return a boolean value indicating success or failure
     */
    boolean removeSelectedAuthor(int authorID);
    
}
