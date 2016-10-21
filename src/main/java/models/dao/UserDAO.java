package models.dao;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Alexis on 21/10/2016.
 */
public class UserDAO {
    private static final String SELECT_BY_EMAIL = "SELECT u FROM User u WHERE u.mail=:mail";
    private static final String PARAM_MAIL = "mail";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext(unitName = "eventmanager")
    private EntityManager em;

    public void create(User user) {
        try {
            em.persist(user);
        } catch (Exception e) {
            // SMTHG
        }
    }

    public User find(String mail) {
        User user = null;
        Query request = em.createQuery(SELECT_BY_EMAIL);
        request.setParameter(PARAM_MAIL, mail);
        try {
            user = (User) request.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            // SMTHG
        }
        return user;
    }
}
