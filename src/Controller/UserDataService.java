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
public class UserDataService extends AllDataService{

    private String  rejected_order;
    private String  type;
    private boolean  activated;
    private String  comfirm_token;

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
    
}
