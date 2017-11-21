/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author kaogi
 */
public class AdminDataService extends DataService{
    private static String nationID;

    public static String getNationID() {
        return nationID;
    }

    public static void setNationID(String nationID) {
        AdminDataService.nationID = nationID;
    }
    
    public static void setAdminDataService(long id, String nationID, String fullname, String email, String tel, String zipCode, String username, String password){
        AdminDataService.setAccountID(id);
        AdminDataService.setNationID(nationID);
        AdminDataService.setFullname(fullname);
        AdminDataService.setEmail(email);
        AdminDataService.setTel(tel);
        AdminDataService.setZipCode(zipCode);
        AdminDataService.setUsername(username);
        AdminDataService.setPassword(password);
    }
    @Override
    public void clear() {
        this.nationID = null;
        super.setOtherAddress(null);
        super.setDistric(null);
        super.setEmail(null);
        super.setFullname(null);
        super.setProvince(null);
        super.setArea(null);
        super.setTel(null);
    }
    
}
