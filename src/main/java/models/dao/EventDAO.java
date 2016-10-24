package models.dao;

import models.Event;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Alexis on 21/10/2016.
 */
public class EventDAO {
    private static final String SELECT_BY_USER = "SELECT e FROM User e WHERE e.user=:user";
    private static final String PARAM_USER = "user";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext(unitName = "eventmanager")
    private EntityManager em;

    public void create(Event event) {
        try {
            em.getTransaction().begin();
            em.persist(event);
            em.getTransaction().commit();
        } catch (Exception e) {
            // SMTHG
        }
    }

    public Event find(User user) {
        Event event = null;
        Query request = em.createQuery(SELECT_BY_USER);
        request.setParameter(PARAM_USER, user);
        try {
            event = (Event) request.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            // SMTHG
        }
        return event;
    }

}
