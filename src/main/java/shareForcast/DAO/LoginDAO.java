package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.model.User;

@Repository
public class LoginDAO {
    private final SessionFactory factory;

    @Autowired
    public LoginDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public boolean exist(String username, String password) {
        User user = null;

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM User where username = :username and password = :password");
            query.setString("username", username);
            query.setString("password", password);
            user = (User) query.uniqueResult();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        if(user != null && user.getUserName().equals(username) && user.getPassword().equals(password))
            return true;
        return false;
    }

    public void insert(User user) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(User user) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
