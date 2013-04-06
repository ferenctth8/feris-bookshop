/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcn.feritoth.services;

import edu.utcn.feritoth.core.Administrator;
import edu.utcn.feritoth.dao.AdministratorDao;
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
@WebService(serviceName = "AdministratorWS")
@Stateless()
public class AdministratorWebService {

    /**
     * The reference towards the database handler class.
     */
    private AdministratorDao administratorDao;

    /**
     * Default class constructor.
     */
    public AdministratorWebService() {
        administratorDao = DaoFactory.getInstance().getAdministratorDao();        
    }       
    
    /**
     * Web service operation for retrieving all administrators.
     */
    @WebMethod(operationName = "returnAllAdmins")
    public String returnAllAdmins() {
        List<Administrator> adminList = administratorDao.getAllAdmins();
        JSONArray adminArray = new JSONArray();
        for (Administrator administrator : adminList) {
            adminArray.add(administrator.createAdministratorJson());
        }
        JSONObject result = new JSONObject();
        result.put("admins", adminArray);
        return result.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findOnlineAdmin")
    public String findOnlineAdmin(@WebParam(name = "emailAddress") String emailAddress, @WebParam(name = "passcode") String passcode) {
        Administrator requiredAdmin = administratorDao.getMatchingAdmin(emailAddress, passcode);
        return requiredAdmin.createAdministratorJson();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findAdminByID")
    public String findAdminByID(@WebParam(name = "adminID") int adminID) {
        Administrator requiredAdmin = administratorDao.findAdministratorByID(adminID);
        return requiredAdmin.createAdministratorJson();
    }
}
