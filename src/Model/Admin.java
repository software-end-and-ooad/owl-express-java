package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author babyjazz
 */
@Entity
public class Admin{
    
    @Id @GeneratedValue
    private long id;
    private String passportID;
    private String fullname;
    private String username;
    private String password;
    private String zipCode;//รหัสไปรษณี
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
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

}
