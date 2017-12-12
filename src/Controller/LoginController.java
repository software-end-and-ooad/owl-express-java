package Controller;

import Model.Postman;
import Model.Customer;
import Model.Entitymanager;
import java.util.ArrayList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author babyjazz
 */
public class LoginController extends Validation {

    private String username;
    private String password;
    private ArrayList<String> validation;

    public LoginController(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean userCheckLogin() {
        Entitymanager db = new Entitymanager("Customer");

        Query userQuery = db.getEM().createQuery("SELECT u FROM Customer u WHERE u.username='" + this.username + "' AND u.password='" + this.password + "'");
        
        try { // try, if can find user
            Customer user = (Customer)userQuery.getSingleResult();
            System.out.println(user.getUsername());
            db.getEM().close();
            //LOAD data to UserDataService
            UserDataService.setDataService(
                    user.getId(), 
                    user.getName(), 
                    user.getEmail(), 
                    user.getTel(), 
                    user.getAddress(), 
                    user.getDistric(), 
                    user.getArea(), 
                    user.getProvince(), 
                    user.getZipCode(), 
                    user.getOtherAddress(), 
                    user.getUsername(), 
                    user.getPassword()
            );
            return true;
        } catch (Exception e) {
            System.out.println("false");
            System.out.print(e);
            db.getEM().close();
            return false;
        }
        
    }
    public boolean adminCheckLogin() {
        Entitymanager db = new Entitymanager("Postman");

        Query adminQuery = db.getEM().createQuery("SELECT a FROM Postman WHERE a.username='" + this.username + "' AND a.password='" + this.password + "'");
        
        try { // try, if can find user
            Postman admin = (Postman)adminQuery.getSingleResult();
            System.out.println(admin.getUsername());
            db.getEM().close();
            //ADD data to PostmanDataService
            PostmanDataService.setAdminDataService(
                    admin.getId(),
                    admin.getNationID(),
                    admin.getFullname(), 
                    admin.getEmail(), 
                    admin.getTel(), 
                    admin.getZipCode(),  
                    admin.getUsername(), 
                    admin.getPassword()
            );
            return true;
        } catch (Exception e) {
            System.out.println("false");
            db.getEM().close();
            return false;
        }
        
    }
    public ArrayList<ArrayList<String>> validateLogin() {
        Validation checkValidate = new Validation();
        ArrayList<String> validate = new ArrayList<String>();

        validate.clear();
        // ADD VALIDATION HERE
        if (!checkValidate.isRequired(this.username))
            validate.add("username|isRequired");
        if (!checkValidate.isRequired(this.password))
            validate.add("password|isRequired");
        
        ArrayList<ArrayList<String>> errList = splitListofValidateError(validate);
        return errList;
    }

    

}
