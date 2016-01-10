package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.model.User;

@Repository
public class RegisterDAO {
    private final SessionFactory factory;

    @Autowired
    public RegisterDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public boolean register(String username, String password, String firstname, String lastname, String email) {
        User user = new User(username, password, firstname, lastname, email);
        insert(user);
        return true;
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
