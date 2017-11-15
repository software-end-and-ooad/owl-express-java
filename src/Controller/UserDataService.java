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

    private static String  rejected_order;
    private static String  type;
    private static boolean  activated;
    private static String  comfirm_token;

    public void setDataService(String fullname, String email, String username, String sub_district, String district, String province, String address_other, String tell) {
        this.setFullname(fullname);
        this.setEmail(email);
        this.setUsername(username);
        this.setSub_distric(sub_district);
        this.setDistric(district);
        this.setProvince(province);
        this.setAddress_other(address_other);
        this.setTell(tell);
        
    }
    
    public String getRejected_order() {
        return rejected_order;
    }

    public void setRejected_order(String rejected_order) {
        this.rejected_order = rejected_order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getComfirm_token() {
        return comfirm_token;
    }

    public void setComfirm_token(String comfirm_token) {
        this.comfirm_token = comfirm_token;
    }

    @Override
    public void clear() {
        this.activated = false;
        this.comfirm_token = null;
        this.rejected_order = null;
        this.type = null;
        super.setAddress_other(null);
        super.setDistric(null);
        super.setEmail(null);
        super.setFullname(null);
        super.setProvince(null);
        super.setSub_distric(null);
        super.setTell(null);
    }
    
}
