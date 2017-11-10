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
public class UserDataService {
    private String fullname;
    private String email;
    private String sub_distric;
    private String distric;
    private String province;
    private String address_other;
    private String  tell;
    private String  password;
    private String  rejected_order;
    private String  type;
    private boolean  activated;
    private String  comfirm_token;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSub_distric() {
        return sub_distric;
    }

    public void setSub_distric(String sub_distric) {
        this.sub_distric = sub_distric;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress_other() {
        return address_other;
    }

    public void setAddress_other(String address_other) {
        this.address_other = address_other;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
}
