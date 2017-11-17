/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Utt
 */
public interface Actor {
    public long getId();
    public String getUsername();
    public void setUsername(String username);
    public String getPassword();
    public void setPassword(String password);
}
