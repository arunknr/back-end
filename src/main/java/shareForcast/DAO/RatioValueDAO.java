package shareForcast.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.helper.RatioValueResponseTransformer;
import shareForcast.model.RatioAttributeValues;

import java.util.HashMap;
import java.util.List;

@Repository
public class RatioValueDAO {
    private final SessionFactory factory;

    @Autowired
    public RatioValueDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<HashMap<String, String>> get(String generatedQuery, List<String> keys) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<HashMap<String, String>> returnValue = null;
        try {
            tx = session.beginTransaction();
            List listOfRatioValues = session.createSQLQuery(generatedQuery).list();
            tx.commit();
            returnValue = RatioValueResponseTransformer.processResponseForRatioValueQuery(keys, listOfRatioValues);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return returnValue;
    }

    public void insert(RatioAttributeValues ratioAttributeValues) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(ratioAttributeValues);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(RatioAttributeValues ratioAttributeValues) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(ratioAttributeValues);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
