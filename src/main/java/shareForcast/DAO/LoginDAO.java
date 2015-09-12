package shareForcast.DAO;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import shareForcast.model.User;

@Component
public class LoginDAO {
    private final SessionFactory factory;

    public LoginDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public boolean exist(String username, String password) {
        User user = null;

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM User where user_name = :username and password = :password");
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
}
