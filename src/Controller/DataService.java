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
    private static String tel;
    private static String address;//ที่อยู่
    private static String distric;//แขวง
    private static String area;//เขต
    private static String province;//จังหวัด
    private static String otherAddress;
    private static String username;
    private static String  password;
    private static String  zipCode;
    private static long accountID;

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        DataService.fullname = fullname;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        DataService.email = email;
    }

    public static String getTel() {
        return tel;
    }

    public static void setTel(String tel) {
        DataService.tel = tel;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        DataService.address = address;
    }

    public static String getDistric() {
        return distric;
    }

    public static void setDistric(String distric) {
        DataService.distric = distric;
    }

    public static String getArea() {
        return area;
    }

    public static void setArea(String area) {
        DataService.area = area;
    }

    public static String getProvince() {
        return province;
    }

    public static void setProvince(String province) {
        DataService.province = province;
    }

    public static String getOtherAddress() {
        return otherAddress;
    }

    public static void setOtherAddress(String otherAddress) {
        DataService.otherAddress = otherAddress;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DataService.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataService.password = password;
    }

    public static long getAccountID() {
        return accountID;
    }

    public static void setAccountID(long accountID) {
        DataService.accountID = accountID;
    }

    public static String getZipCode() {
        return zipCode;
    }

    public static void setZipCode(String zipCode) {
        DataService.zipCode = zipCode;
    }

    public abstract void clear();
    
}
