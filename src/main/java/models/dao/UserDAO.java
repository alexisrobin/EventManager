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
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ERROR CREATE");
            System.out.println(e);
        }
    }

    public User find(String mail) {
        User user = null;
        Query request = em.createQuery(SELECT_BY_MAIL, User.class);
        request.setParameter(PARAM_MAIL, mail);
        try {
            user = (User) request.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.out.println("ERROR FIND");
            System.out.println(e);
        }
        return user;
    }
}
