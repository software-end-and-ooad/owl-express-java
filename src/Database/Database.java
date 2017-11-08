/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Utt
 */
public class Database {
    EntityManagerFactory emf;
    EntityManager em;
    String id;
    String passDb;
    String userDb;
    public Database( String table){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb://localhost/db/"+table+".odb;user=admin;password=admin");
        EntityManager em = emf.createEntityManager();
    }
}
