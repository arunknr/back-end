package shareForcast.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.helper.RatiovalueResponseTransformer;

import java.util.HashMap;
import java.util.List;

@Repository
public class RatioValueDAO {
    private final SessionFactory factory;
    private RatiovalueResponseTransformer ratiovalueResponseTransformer;

    @Autowired
    public RatioValueDAO(SessionFactory sessionFactory, RatiovalueResponseTransformer ratiovalueResponseTransformer) {
        this.ratiovalueResponseTransformer = ratiovalueResponseTransformer;
        factory = sessionFactory;
    }

    public List<HashMap<String, String>> get(String generatedQuery, List<String> keys) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List listOfRatioValues = session.createSQLQuery(generatedQuery).list();
            tx.commit();

            return ratiovalueResponseTransformer.processResponseForRatioValueQuery(keys, listOfRatioValues);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
