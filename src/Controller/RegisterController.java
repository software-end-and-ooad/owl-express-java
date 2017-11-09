/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import javax.persistence.Query;

/**
 *
 * @author babyjazz
 */
public class RegisterController {
    private String username;
    private String password;

    public RegisterController(String username, String email, String name, String tell, String password, String confirmPass) {
        
    }
    
    public boolean checkRegister() {
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
