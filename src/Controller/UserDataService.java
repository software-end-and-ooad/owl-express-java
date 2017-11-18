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

    public void setDataService(long id,String fullname, String email, String username, String area, String district, String province, String tel) {
        this.setAccountID(id);
        this.setFullname(fullname);
        this.setEmail(email);
        this.setUsername(username);
        this.setArea(area);
        this.setDistric(district);
        this.setProvince(province);
        this.setTel(tel);
        
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
        super.setDistric(null);
        super.setEmail(null);
        super.setFullname(null);
        super.setProvince(null);
        super.setArea(null);
        super.setTel(null);
        super.setOtherAddress(null);
    }
    
}
