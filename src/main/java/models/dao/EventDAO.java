package models.dao;

import models.Event;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Created by Alexis on 21/10/2016.
 */
public class EventDAO {
    private static final String SELECT_BY_USER = "SELECT e FROM Event e WHERE e.user=:user";
    private static final String SELECT_BY_ID = "SELECT e FROM Event e WHERE e.id=:id";
    private static final String PARAM_USER = "user";
    private static final String PARAM_ID = "id";

    private EntityManager em;

    public EventDAO(){
        em = EntityManagerProvider.getEntityManager();
    }

    public void create(Event event) {
        try {
            em.getTransaction().begin();
            em.persist(event);
            em.getTransaction().commit();
        } catch (Exception e) {
            // SMTHG
        }
    }

    public Event findEventById(int id) {
        Event event = null;
        Query request = em.createQuery(SELECT_BY_ID);
        request.setParameter(PARAM_ID, id);
        try {
            event = (Event) request.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return event;
    }

    public ArrayList<Event> findEventsByUser(User user) {
        ArrayList<Event> events = new ArrayList<>();
        Query request = em.createQuery(SELECT_BY_USER);
        request.setParameter(PARAM_USER, user);
        try {
            events = (ArrayList<Event>) request.getResultList();
            System.out.println(events);
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return events;
    }

    public void delete(Event event) {
        try {
            em.getTransaction().begin();
            em.remove(event);
            em.getTransaction().commit();
        } catch (Exception e) {
            // SMTHG
        }
    }

}
