package Model;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author babyjazz
 */
@Entity
public class Postman{
    
    @Id @GeneratedValue
    private long id;
    private String role;
    private String nationID;
    private String fullname;
    private String email;
    private String tel;
    private String username;
    private String password;
    private String zipCode;//รหัสไปรษณี

    public Postman(String nationID, String fullname, String email, String tel, 
            String username, String password, String zipCode, String role ) {
        this.nationID = nationID;
        this.fullname = fullname;
        this.email = email;
        this.tel = tel;
        this.username = username;
        this.password = password;
        this.zipCode = zipCode;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getNationID() {
        return nationID;
    }

    public void setNationID(String nationID) {
        this.nationID = nationID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
