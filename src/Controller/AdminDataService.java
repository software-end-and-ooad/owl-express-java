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
    private String  role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void clear() {
        this.role = null;
        super.setAddress_other(null);
        super.setDistric(null);
        super.setEmail(null);
        super.setFullname(null);
        super.setProvince(null);
        super.setSub_distric(null);
        super.setTel(null);
    }
    
}
