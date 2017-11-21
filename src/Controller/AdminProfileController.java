/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import Model.Database;
import Model.User;
import java.util.ArrayList;

/**
 *
 * @author 58011424
 */
public class AdminProfileController extends Validation{
    private String fullname;
    private String email;
    private String tel;
    private String nationID;
    private String zipCode;
    public AdminProfileController(String fullname, String email, String tel, String zipCode, String nationID) {
        this.fullname = fullname;
        this.email = email;
        this.tel = tel;
        this.nationID = nationID;
        this.zipCode = zipCode;
    }
    public ArrayList<ArrayList<String>> validateProfile(){
    Validation checkValidate = new Validation();
        ArrayList<String> validate = new ArrayList<String>();
        
        validate.clear();
        // ADD VALIDATION HERE
        if (!checkValidate.isRequired(this.fullname))
            validate.add("fullname|isRequired");
        if (!checkValidate.maxLength(this.fullname, 20))
            validate.add("fullname|maxLength");
        if (!checkValidate.isEmail(this.email))
            validate.add("email|maxLength");
        if (!checkValidate.isRequired(this.email))
            validate.add("email|isRequired");
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
        if (!checkValidate.maxLength(this.nationID, 14))
            validate.add("nationID|maxLength");
        if (!checkValidate.minLength(this.nationID, 12))
            validate.add("nationID|minLength");
        if (!checkValidate.isNumeric(this.nationID))
            validate.add("nationID|isNumeric");
        if (!checkValidate.isRequired(this.zipCode))
            validate.add("zipCode|isRequired");
        if (!checkValidate.isNumeric(this.zipCode))
            validate.add("zipCode|isNumeric");
        if (!checkValidate.maxLength(this.zipCode, 6))
            validate.add("zipCode|maxLength");
        if (!checkValidate.minLength(this.zipCode, 5))
            validate.add("zipCode|minLength");

        ArrayList<ArrayList<String>> errList = splitListofValidateError(validate);
        return errList;
    }
    public void editProfile(){
        //UPDATE dataservice
        AdminDataService.setFullname(this.fullname);
        AdminDataService.setEmail(this.email);
        AdminDataService.setTel(this.tel);
        AdminDataService.setNationID(this.nationID);
        AdminDataService.setZipCode(this.zipCode);
        //UPDATE database
        Database db = new Database("Admin");
        Admin admin = db.getEM().find(Admin.class, AdminDataService.getAccountID());
        db.getEM().getTransaction().begin();
        admin.setFullname(this.fullname);
        admin.setEmail(this.email);
        admin.setTel(this.tel);
        admin.setZipCode(this.zipCode);
        admin.setNationID(this.nationID);
        db.getEM().getTransaction().commit();
    }
}
