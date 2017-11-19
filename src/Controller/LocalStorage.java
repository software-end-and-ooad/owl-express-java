/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

/**
 *
 * @author babyjazz
 */
public class LocalStorage{
    
    private File file = new File("loginfile.txt");
    private Path path = Paths.get("loginfile.txt");
    private String username;
    private String password;
    private String role;
    public void setAuthen(String username, String password, String role) {
        // Convert the string to a
        // byte array.
        byte usernameData[] = username.getBytes();
        byte passwordData[] = password.getBytes();
        byte roleData[] = role.getBytes();
        
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(path, CREATE))) {
            out.write(usernameData, 0, usernameData.length);
            out.write("\r\n".getBytes());
            out.write(passwordData, 0, passwordData.length);
            out.write("\r\n".getBytes());
            out.write(roleData, 0, roleData.length);
            out.close();
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    public boolean checkAuthen(){
        
        try {
            InputStreamReader in = new InputStreamReader((InputStream)Files.newInputStream(path));
            BufferedReader reader = new BufferedReader(in);
            this.username = reader.readLine();
            this.password = reader.readLine();
            this.role = reader.readLine();
            in.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean resetAuthen(){
        return this.file.delete();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    
}
