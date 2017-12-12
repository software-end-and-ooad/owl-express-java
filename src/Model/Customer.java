package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author babyjazz
 */
@Entity
public class Customer{
    @Id @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String tel;
    private String address;
    private String distric;
    private String area;
    private String province;
    private String zipCode;
    private String otherAddress;
    private String username;
    private String password;
    
    public Customer(String username, String password, String email, String name, 
            String tel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.tel = tel;
    }
    
    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(String otherAddress) {
        this.otherAddress = otherAddress;
    }
    
    @Override
    public String toString()
    {
        String string = String.format("UserID  :  %s\n\tUsername  : "
                + " %s\n\tFullname  :  %s\n\tEmail  :  %s\n\tZipcode  :  "
                + "%s ", 
                this.id, 
                this.username, 
                this.name, 
                this.email, 
                this.zipCode);
        return string;
    }
    
}
