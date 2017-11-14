/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.User;
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
    private boolean uniqueUsername;
    private boolean uniqueEmail;
//    private Validation validator = new Validation();
    
    public RegisterController(String username, String password, String confirmPass, String email, String name, String tell) {
        this.username = username;
        this.password = password;
        this.confirmPass = confirmPass;
        this.email = email;
        this.name = name;
        this.tell = tell;
    }
    public ArrayList<ArrayList<String>> validateResgister(){
        Validation checkValidate = new Validation();
        ArrayList<String> validate = new ArrayList<String>();
        
        validate.clear();
        // ADD VALIDATION HERE
        if (!checkValidate.maxLength(this.username, 8))
            validate.add("username|maxLength");
        if (!checkValidate.minLength(this.username, 4))
            validate.add("username|minLength");
        if (!checkValidate.isRequired(this.username))
            validate.add("username|isRequired");
        if (!checkValidate.maxLength(this.name, 20))
            validate.add("name|maxLength");
        if (!checkValidate.isRequired(this.name))
            validate.add("name|isRequired");
        if (!checkValidate.isRequired(this.email))
            validate.add("name|isRequired");
        if (!checkValidate.isEmail(this.email))
            validate.add("email|isEmail");
        if (!checkValidate.isRequired(this.tell))
            validate.add("tell|isRequired");
        if (!checkValidate.maxLength(this.tell, 11))
            validate.add("tell|maxLength");
        if (!checkValidate.minLength(this.tell, 9))
            validate.add("tell|minLength");
        if (!checkValidate.isNumeric(this.tell))
            validate.add("tell|isNumeric");
        if (!checkValidate.minLength(this.password, 2))
            validate.add("password|minLength");
        if (!checkValidate.isSame(this.confirmPass, this.password))
            validate.add("confirmPass|isSame");

        ArrayList<ArrayList<String>> errList = splitListofValidateError(validate);
        return errList;
    }
    
    private ArrayList splitListofValidateError(ArrayList errList) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < errList.size(); i++) {
            String errValidate = (String) errList.get(i);
            String fieldError = errValidate.substring(0, errValidate.indexOf("|"));
            String ruleError = errValidate.substring(errValidate.indexOf("|")+1);

            result.add(new ArrayList<String>());
            result.get(i).add(fieldError);
            result.get(i).add(ruleError);
        }
        return result;
    }
    
    
    public boolean checkRegister() {
        this.uniqueEmail = false;
        this.uniqueUsername = false;
        
        
        Database db = new Database("User");
        
        // FIND OR CREATE     // UNIQUE USERNAME AND UNIQUE EMAIL
        Query uniqueUsername = db.getEM().createQuery("SELECT username FROM User WHERE username='" + this.username + "'", User.class);
        Query uniqueEmail = db.getEM().createQuery("SELECT email FROM User WHERE email='" + this.email + "'", User.class);
        
        // Check unique username and email first
        if (uniqueUsername.getResultList().size() <= 0) {
            if (uniqueEmail.getResultList().size() <= 0) {
                try {
                    // Create user
                    db.getEM().getTransaction().begin();
                    User user = new User(this.username, this.password, this.confirmPass, this.email, this.name, this.tell);
                    db.getEM().persist(user);
                    db.getEM().getTransaction().commit();
                    db.getEM().close();
                    return true;
                } catch(Throwable error) {
                    System.out.println("CANNOT CREATE USER, PLEASE CHECK SERVER ");
                    db.getEM().close();
                    return false;
                }
            } else { // EMAIL HAS ALREADY TAKEN
                this.uniqueEmail = true;
                return false;
            }
        } else { // USERNAME HAS ALERADY TAKEN
            this.uniqueUsername = true;
            return false;
        }
       
    }
    
    public boolean getUniqueEmail() {
        return this.uniqueEmail;
    }
    
    public boolean getUniqueUsername() {
        return this.uniqueUsername;
    }
    
}
