/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import java.util.ArrayList;
import javax.persistence.Query;

/**
 *
 * @author babyjazz
 */
public class RegisterController {
    private String username;
    private String password;
    private String confirmPass;
    private String email;
    private String name;
    private String tell;
    private Validation validator = new Validation();
    private ArrayList<String> inputs = new ArrayList<String>();
    
    public RegisterController(String username, String password, String confirmPass, String email, String name, String tell) {
        this.username = username;
        this.password = password;
        this.confirmPass = confirmPass;
        this.email = email;
        this.name = name;
        this.tell = tell;
        this.inputs.add(username);
        this.inputs.add(password);
        this.inputs.add(confirmPass);
        this.inputs.add(email);
        this.inputs.add(name);
        this.inputs.add(tell);
    }
    public void validateResgister(){
        
        if(validator.checkValidate(this.inputs).size() <= 0) {
            System.out.println(validator.checkValidate(this.inputs).size());
        }
    }
    public void checkRegister() {
        System.out.println(this.username);
//        Database db = new Database("user");
        System.out.println(this.validator.checkValidate(this.inputs).size());
        
//        Query user = db.getEM().createQuery("SELECT username, password FROM User where username='" + this.username + "' and password='" + this.password + "'");
//        try { // try, if can print method in user
//            System.out.println(user.getSingleResult());
//            return true;
//        }
//        catch(Exception e) {
//            System.out.println("false");
//            return false;
//        }
    }
    
}
