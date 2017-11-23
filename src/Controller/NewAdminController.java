/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import Model.Database;
import java.util.ArrayList;
import javax.persistence.Query;

/**
 *
 * @author kaogi
 */
public class NewAdminController  extends Validation{

    private final String nationID;
    private final String name;
    private final String email;
    private final String tel;
    private final String username;
    private final String password;
    private final String zipCode;
    private final String confirmPass;
    private boolean uniqueEmail;
    private boolean uniqueUsername;
    
    
    public NewAdminController(String nationID, String name, String email, String tel, String username, String password, String confirmPass,String zipCode) {
        this.nationID = nationID;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.username = username;
        this.password = password;
        this.zipCode = zipCode;
        this.confirmPass = confirmPass;
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
        if (!checkValidate.isRequired(this.nationID))
            validate.add("nationID|isRequired");
        if (!checkValidate.maxLength(this.nationID, 13))
            validate.add("nationID|size");
        if (!checkValidate.minLength(this.nationID, 13))
            validate.add("nationID|size");
        if (!checkValidate.isNumeric(this.nationID))
            validate.add("nationID|isNumeric");
        if (!checkValidate.maxLength(this.zipCode, 5))
            validate.add("zipcode|size");
        if (!checkValidate.minLength(this.tel, 5))
            validate.add("zipCode|size");
        if (!checkValidate.isNumeric(this.zipCode))
            validate.add("zipCode|isNumeric");
        if (!checkValidate.isRequired(this.zipCode))
            validate.add("zipCode|isRequired");
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
        
        
        Database db = new Database("Admin");
        
        // FIND OR CREATE     // UNIQUE USERNAME AND UNIQUE EMAIL
        Query uniqueUsername = db.getEM().createQuery("SELECT username FROM Admin WHERE username='" + this.username + "'", Admin.class);
        Query uniqueEmail = db.getEM().createQuery("SELECT email FROM Admin WHERE email='" + this.email + "'", Admin.class);
        
        // Check unique username and email first
        if (uniqueUsername.getResultList().size() <= 0) {
            if (uniqueEmail.getResultList().size() <= 0) {
                try {
                    // Create user
                    db.getEM().getTransaction().begin();
                    Admin admin = new Admin(this.nationID, this.name, this.email, this.tel, this.username, this.password, this.zipCode);
                    db.getEM().persist(admin);
                    db.getEM().getTransaction().commit();
                    db.getEM().close();
                    return true;
                } catch(Throwable error) {
                    System.out.println("CANNOT CREATE Admin, PLEASE CHECK SERVER ");
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

    public boolean getUniqueUsername() {
        return this.uniqueUsername;
    }

    public boolean getUniqueEmail() {
       return this.uniqueEmail;
    }
    
}
