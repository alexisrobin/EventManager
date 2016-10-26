package models.dao;

import models.Event;
import models.Registrant;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Created by Alexis on 25/10/2016.
 */
public class RegistrantDAO {
    private static final String SELECT_BY_EVENT = "SELECT r FROM Registrant r WHERE r.event=:event";
    private static final String PARAM_EVENT = "event";

    private EntityManager em;

    public RegistrantDAO(){
        em = EntityManagerProvider.getEntityManager();
    }

    public void create(Registrant registrant) {
        try {
            em.getTransaction().begin();
            em.persist(registrant);
            em.getTransaction().commit();
        } catch (Exception e) {
            // SMTHG
        }
    }

    public ArrayList<Registrant> findRegistrantsByEvent(Event event) {
        ArrayList<Registrant> registrants = new ArrayList<>();
        Query request = em.createQuery(SELECT_BY_EVENT);
        request.setParameter(PARAM_EVENT, event);
        try {
            registrants = (ArrayList<Registrant>) request.getResultList();
            System.out.println(registrants);
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return registrants;
    }

}
