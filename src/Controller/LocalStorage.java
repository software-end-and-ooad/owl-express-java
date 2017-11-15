/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileReader;

/**
 *
 * @author babyjazz
 */
public class LocalStorage extends UserDataService{
    
    public void setAuthen() {
        
        try {
            System.out.println(this.getUsername());
            System.out.println("set storage");
        } catch(Exception error) {
            System.out.println("Cannot set authentication in local storage");
        }
    }
}
