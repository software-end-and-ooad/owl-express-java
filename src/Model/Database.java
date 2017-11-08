/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Utt
 */
public class Database {
    public EntityManager em;
    String ip = "localhost";
    String passDb = "admin";
    String userDb =  "admin";
    public Database( String table){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb://"+ this.ip +"/db/"+ table +".odb;user="+ this.userDb +";password="+ this.passDb);
        this.em = emf.createEntityManager();
    }
    
    public EntityManager getEM() {
        return this.em;
    }
}
