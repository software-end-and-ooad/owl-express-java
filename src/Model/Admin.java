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
    private String username;
    private String password;
    
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


   
}
