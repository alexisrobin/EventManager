package models.dao;

import models.User;

import javax.persistence.*;

/**
 * The user's model DAO.
 */
public class UserDAO {
    private static final String SELECT_BY_MAIL = "SELECT u FROM User u WHERE u.mail=:mail AND u.password=:password";
    private static final String PARAM_MAIL = "mail";
    private static final String PARAM_PASSWORD = "password";

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

    public User find(String mail, String password) {
        User user = null;
        Query request = em.createQuery(SELECT_BY_MAIL, User.class);
        request.setParameter(PARAM_MAIL, mail);
        request.setParameter(PARAM_PASSWORD, password);
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
