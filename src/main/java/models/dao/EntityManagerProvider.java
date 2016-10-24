package models.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Alexis on 21/10/2016.
 */
public class EntityManagerProvider {
    private static String UNIT_NAME = "eventmanager-unit";
    private static EntityManager em;

    public static EntityManager getEntityManager(){
        if (em==null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
            em = emf.createEntityManager();
        }
        return em;
    }
}
