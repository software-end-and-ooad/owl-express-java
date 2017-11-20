/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Utt
 */
public class UserDataService extends DataService{

    /**
     *
     * @param id
     * @param fullname
     * @param email
     * @param tel
     * @param address
     * @param district
     * @param area
     * @param province
     * @param zipCode
     * @param otherAddress
     * @param username
     * @param password
     */
    public static void setDataService(long id, String fullname, String email, String tel, String address, String district, String area, String province, String zipCode, String otherAddress, String username, String password) {
        DataService.setAccountID(id);
        DataService.setFullname(fullname);
        DataService.setEmail(email);
        DataService.setTel(tel);
        DataService.setAddress(address);
        DataService.setDistric(district);
        DataService.setArea(area);
        DataService.setProvince(province);
        DataService.setZipCode(zipCode);
        DataService.setOtherAddress(otherAddress);
        DataService.setUsername(username);
        DataService.setPassword(password);
    }
    
    @Override
    public void clear() {
        super.setAccountID(0);
        super.setFullname(null);
        super.setEmail(null);
        super.setTel(null);
        super.setAddress(null);
        super.setDistric(null);
        super.setArea(null);
        super.setProvince(null);
        super.setZipCode(null);
        super.setOtherAddress(null);
        super.setUsername(null);
        super.setPassword(null);
    }
    
}
