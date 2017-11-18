/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.User;
import java.util.ArrayList;

/**
 *
 * @author 58011424
 */
public class ProfileMenuController extends Validation{
    private String fullname;
    private String email;
    private String tel;
    private String address;
    private String distric;
    private String area;
    private String province;
    private String zipCode;
    private String otherAddress;

    public ProfileMenuController(String fullname, String email, String tel, String address, String distric, String area, String province, String zipCode, String otherAddress) {
        this.fullname = fullname;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.distric = distric;
        this.area = area;
        this.province = province;
        this.zipCode = zipCode;
        this.otherAddress = otherAddress;
    }
    public ArrayList<ArrayList<String>> validateProfile(){
    Validation checkValidate = new Validation();
        ArrayList<String> validate = new ArrayList<String>();
        
        validate.clear();
        // ADD VALIDATION HERE
        if (!checkValidate.maxLength(this.fullname, 20))
            validate.add("fullname|maxLength");
        if (!checkValidate.isRequired(this.fullname))
            validate.add("fullname|isRequired");
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
        if (!checkValidate.isRequired(this.address))
            validate.add("address|isRequired");
        if (!checkValidate.isRequired(this.distric))
            validate.add("distric|isRequired");
        if (!checkValidate.isRequired(this.area))
            validate.add("area|isRequired");
        if (!checkValidate.isRequired(this.province))
            validate.add("province|isRequired");
        if (!checkValidate.isNumeric(this.zipCode))
            validate.add("zipCode|isNumeric");
        if (!checkValidate.maxLength(this.zipCode, 6))
            validate.add("zipCode|maxLength");
        if (!checkValidate.minLength(this.zipCode, 5))
            validate.add("zipCode|minLength");
        if (!checkValidate.isRequired(this.zipCode))
            validate.add("zipCode|isRequired");

        ArrayList<ArrayList<String>> errList = splitListofValidateError(validate);
        return errList;
    }
    public void editProfile(){
        //UPDATE dataservice
        UserDataService.setFullname(this.fullname);
        UserDataService.setEmail(this.email);
        UserDataService.setTel(this.tel);
        UserDataService.setAddress(this.address);
        UserDataService.setDistric(this.distric);
        UserDataService.setArea(this.area);
        UserDataService.setProvince(this.province);
        UserDataService.setZipCode(this.zipCode);
        UserDataService.setOtherAddress(otherAddress);
        //UPDATE database
        Database db = new Database("User");
        User user = db.getEM().find(User.class, UserDataService.getAccountID());
        db.getEM().getTransaction().begin();
        user.setName(this.fullname);
        user.setEmail(this.email);
        user.setTel(this.tel);
        user.setAddress(this.address);
        user.setDistric(this.distric);
        user.setArea(this.area);
        user.setProvince(this.province);
        user.setZipCode(this.zipCode);
        user.setOtherAddress(this.otherAddress);
        db.getEM().getTransaction().commit();
    }
//     private String fullname;
//    private String email;
//    private String tel;
//    private String address;
//    private String distric;
//    private String area;
//    private String province;
//    private String zipCode;
}
