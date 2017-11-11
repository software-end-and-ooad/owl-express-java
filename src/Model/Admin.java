package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author babyjazz
 */
@Entity
public class Admin implements Actor{
    
    @Id @GeneratedValue
    private long id;
    private String username;
    private String password;
    
    @Override
    public long getId() {
        return id;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }


   
}
