package models.dao;

import models.User;

import javax.persistence.*;

/**
 * Created by Alexis on 21/10/2016.
 */
public class UserDAO {
    private static final String SELECT_BY_MAIL = "SELECT u FROM User u WHERE u.mail=:mail";
    private static final String PARAM_MAIL = "mail";

    private EntityManager em;

    public UserDAO(){
        em = EntityManagerProvider.getEntityManager();
    }

    public void create(User user) {
        try {
            em.persist(user);
        } catch (Exception e) {
            // SMTHG
        }
    }

    public User find(String mail) {
        User user = null;
        Query request = em.createQuery(SELECT_BY_MAIL);
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
