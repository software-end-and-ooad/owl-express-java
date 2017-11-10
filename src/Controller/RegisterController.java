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
        
        if (!checkValidate.maxLength(this.username, 4))
            validate.add("username|maxLength");
        if (!checkValidate.minLength(this.username, 2))
            validate.add("username|minLength");

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
        
        
        Database db = new Database("user");
        return false;
        
        // FIND OR CREATE
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
