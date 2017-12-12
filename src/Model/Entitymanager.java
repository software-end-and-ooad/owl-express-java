package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Utt
 */
public class Entitymanager {
    public EntityManager em;
    String ip = "161.246.34.35";
    String passDb = "admin";
    String userDb =  "admin";
    public Entitymanager(String table){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb://"+ this.ip +
                    "/db/"+ table +".odb;user="+ this.userDb +";password="+ 
                    this.passDb);
        this.em = emf.createEntityManager();
    }
    
    public EntityManager getEM() {
        return this.em;
    }
}
