/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.webservices;

import edu.utcn.feritoth.core.Author;
import edu.utcn.feritoth.dao.AuthorDao;
import edu.utcn.feritoth.dao.DaoFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Feri
 */
@WebService(serviceName = "AuthorWS")
@Stateless()
public class AuthorWebService {

    /**
     * The reference to the hibernate database class.
     */
    private AuthorDao authorDao;

    /**
     * Default constructor for web service invocation.
     */
    public AuthorWebService() {
        authorDao = DaoFactory.getInstance().getAuthorDao();
    }

    /**
     * Web service operation for finding an author with a given ID
     */
    @WebMethod(operationName = "findAuthorByID")
    public String findAuthorByID(@WebParam(name = "authorID") int authorID) {
        Author requestedAuthor = authorDao.findAuthorByID(authorID);
        return requestedAuthor.createAuthorJson();
    }

    /**
     * Web service operation for returning all registered authors.
     */
    @WebMethod(operationName = "returnAllAuthors")
    public String returnAllAuthors() {
        List<Author> authorList = authorDao.getAllAuthors();
        JSONArray authorArray = new JSONArray();
        for (Author author : authorList) {
            authorArray.add(author.createAuthorJson());
        }
        JSONObject result = new JSONObject();
        result.put("authors", authorArray);
        return result.toString();
    }

    /**
     * Web service operation for removing an author from the database.
     */
    @WebMethod(operationName = "deleteAuthor")
    public boolean deleteAuthor(@WebParam(name = "authorID") int authorID) {        
        return authorDao.removeSelectedAuthor(authorID);
    }

    /**
     * Web service operation for updating the description of an author from the database.
     */
    @WebMethod(operationName = "updateAuthor")
    public boolean updateAuthor(@WebParam(name = "authorID") int authorID, @WebParam(name = "newDescription") String newDescription) {
        return authorDao.updateExistingAuthor(authorID, newDescription);
    }

    /**
     * Web service operation for finding all authors whose name contains a sequence given as parameter.
     */
    @WebMethod(operationName = "findMatchingAuthors")
    public String findMatchingAuthors(@WebParam(name = "nameSequence") String nameSequence) {
        List<Author> authorList = authorDao.getMatchingAuthors(nameSequence);
        JSONArray authorArray = new JSONArray();
        for (Author author : authorList) {
            authorArray.add(author.createAuthorJson());
        }
        JSONObject result = new JSONObject();
        result.put("authors", authorArray);
        return result.toString();
    }

    /**
     * Web service operation for registration of new author.
     */
    @WebMethod(operationName = "registerNewAuthor")
    public boolean registerNewAuthor(@WebParam(name = "name") String name, @WebParam(name = "surname") String surname, @WebParam(name = "birthYear") int birthYear, @WebParam(name = "deathYear") int deathYear, @WebParam(name = "shortDescription") String shortDescription, @WebParam(name = "referencePage") String referencePage) {
        return authorDao.registerNewAuthor(name, surname, birthYear, deathYear, shortDescription, referencePage);
    }
}
