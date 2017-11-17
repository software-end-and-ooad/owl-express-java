/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Utt
 */
public abstract class DataService {
    private static String fullname;
    private static String email;
    private static String username;
    private static String sub_distric;
    private static String distric;
    private static String province;
    private static String address_other;
    private static String  tell;
    private static String  password;

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        DataService.fullname = fullname;
    }
    
    public static void setUsername(String username) {
        DataService.username = username;
    }
    
    public static String getUsername() {
        return username;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        DataService.email = email;
    }

    public static String getSub_distric() {
        return sub_distric;
    }

    public static void setSub_distric(String sub_distric) {
        DataService.sub_distric = sub_distric;
    }

    public static String getDistric() {
        return distric;
    }

    public static void setDistric(String distric) {
        DataService.distric = distric;
    }

    public static String getProvince() {
        return province;
    }

    public static void setProvince(String province) {
        DataService.province = province;
    }

    public static String getAddress_other() {
        return address_other;
    }

    public static void setAddress_other(String address_other) {
        DataService.address_other = address_other;
    }

    public static String getTell() {
        return tell;
    }

    public static void setTell(String tell) {
        DataService.tell = tell;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataService.password = password;
    }
    
    public abstract void clear();
    
}
