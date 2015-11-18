package shareForcast.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RatioValueDAO {
    private final SessionFactory factory;

    public RatioValueDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public List<HashMap<String, String>> get(String generatedQuery, List<String> keys) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List listOfRatioValues = session.createSQLQuery(generatedQuery).list();
            tx.commit();

            HashMap<String, String> map = null;
            List<HashMap<String, String>> hashMapList = new ArrayList<>();
            for (Object ratioValue : listOfRatioValues) {
                map = new HashMap<>();
                Object[] value = (Object[]) ratioValue;
                for(int i=0; i< keys.size(); i++){
                    map.put(keys.get(i), value[i].toString());
                }
                hashMapList.add(map);
            }

            return hashMapList;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
