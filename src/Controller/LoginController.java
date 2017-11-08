package Controller;

import API.User;
import Model.Database;
import java.util.ArrayList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    
    public void checkLogin() {
        Database db = new Database("user");
        
        db.getEM().getTransaction().begin();
        db.getEM().getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            User p = new User();
            db.getEM().persist(p);
        }
        db.getEM().getTransaction().commit();
 
//        // Find the number of Point objects in the database:
//        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
//        System.out.println("Total Points: " + q1.getSingleResult());
      

    }
    
}
