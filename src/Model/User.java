package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author babyjazz
 */
@Entity
public class User implements Actor{
    @Id @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String confirmPass;
    private String tell;
    private String email;
    private String name;

    public User(String username, String password, String confirmPass, String email, String name, String tell) {
        this.username = username;
        this.password = password;
        this.confirmPass = confirmPass;
        this.email = email;
        this.name = name;
        this.tell = tell;
    }

    public User() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
    public String getConfirmPass() {
        return this.confirmPass;
    }
    public String getEmail() {
        return this.email;
    }
    public String getName() {
        return this.name;
    }
    public String getTell() {
        return this.tell;
    }
}
