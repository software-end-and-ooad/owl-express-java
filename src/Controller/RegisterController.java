/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entitymanager;
import Model.Customer;
import java.util.ArrayList;
import javax.persistence.Query;

/**
 *
 * @author babyjazz
 */
public class RegisterController extends Validation{
    private String username;
    private String password;
    private String confirmPass;
    private String email;
    private String name;
    private String tel;
    private boolean uniqueUsername;
    private boolean uniqueEmail;
//    private Validation validator = new Validation();
    
    public RegisterController(String username, String password, 
            String confirmPass, String email, String name, String tel) {
        this.username = username;
        this.password = password;
        this.confirmPass = confirmPass;
        this.email = email;
        this.name = name;
        this.tel = tel;
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
        if (!checkValidate.isRequired(this.tel))
            validate.add("tel|isRequired");
        if (!checkValidate.maxLength(this.tel, 11))
            validate.add("tel|maxLength");
        if (!checkValidate.minLength(this.tel, 9))
            validate.add("tel|minLength");
        if (!checkValidate.isNumeric(this.tel))
            validate.add("tel|isNumeric");
        if (!checkValidate.minLength(this.password, 2))
            validate.add("password|minLength");
        if (!checkValidate.isSame(this.confirmPass, this.password))
            validate.add("confirmPass|isSame");

        ArrayList<ArrayList<String>> errList = splitListofValidateError(validate);
        return errList;
    }
    
    
    
    public boolean checkRegister() {
        this.uniqueEmail = false;
        this.uniqueUsername = false;
        
        
        Entitymanager db = new Entitymanager("Customer");
        
        // FIND OR CREATE     // UNIQUE USERNAME AND UNIQUE EMAIL
        Query uniqueUsername = db.getEM().createQuery("SELECT username FROM Customer WHERE username='" + this.username + "'", Customer.class);
        Query uniqueEmail = db.getEM().createQuery("SELECT email FROM Customer WHERE email='" + this.email + "'", Customer.class);
        
        // Check unique username and email first
        if (uniqueUsername.getResultList().size() <= 0) {
            if (uniqueEmail.getResultList().size() <= 0) {
                return true;
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
