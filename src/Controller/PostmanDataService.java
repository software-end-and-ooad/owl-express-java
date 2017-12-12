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
public class PostmanDataService extends DataService{
    private static String nationID;

    public static String getNationID() {
        return nationID;
    }

    public static void setNationID(String nationID) {
        PostmanDataService.nationID = nationID;
    }
    
    public static void setAdminDataService(long id, String nationID, String fullname, String email, String tel, String zipCode, String username, String password){
        PostmanDataService.setAccountID(id);
        PostmanDataService.setNationID(nationID);
        PostmanDataService.setFullname(fullname);
        PostmanDataService.setEmail(email);
        PostmanDataService.setTel(tel);
        PostmanDataService.setZipCode(zipCode);
        PostmanDataService.setUsername(username);
        PostmanDataService.setPassword(password);
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
