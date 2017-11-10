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
    
    public boolean minLength(String input, int min) {
        if (input.length() < min) 
            return false;
        return true;
    }
    
    
    public boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
        if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    
    public boolean isChar(String str)
    {
        for (char c : str.toCharArray())
        {
        if (Character.isDigit(c)) return false;
        }
        return true;
    }
    
    public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
    
    
}
