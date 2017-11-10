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
public abstract class DataService {
    private String fullname;
    private String email;
    private String sub_distric;
    private String distric;
    private String province;
    private String address_other;
    private String  tell;
    private String  password;

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
    
    public abstract void clear();
}
