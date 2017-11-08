/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author babyjazz
 */
public class Validation {
    
    public boolean maxLength(String input, int max) {
        if (input.length() > max) 
            return false;
        return true;
    }
    
}
