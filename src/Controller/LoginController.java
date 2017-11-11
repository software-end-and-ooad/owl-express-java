package Controller;

import Model.User;
import Model.Database;
import java.util.ArrayList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author babyjazz
 */
public class LoginController {
    private String username;
    private String password;
    private ArrayList<String> validation;
    

    public LoginController(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean checkLogin() {
        System.out.println(this.username);
        Database db = new Database("user");
        
        Query user = db.getEM().createQuery("SELECT username, password FROM User where username='" + this.username + "' and password='" + this.password + "'");
        try { // try, if can print method in user
            System.out.println(user.getSingleResult());
            return true;
        }
        catch(Exception e) {
            System.out.println("false");
            return false;
        }
        
    }
    
}
