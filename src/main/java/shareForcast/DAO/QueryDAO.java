package shareForcast.DAO;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import shareForcast.model.CompanyShareValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class QueryDAO {
    private final SessionFactory factory;

    public QueryDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public List<CompanyShareValue> get(String generatedQuery) {

        List<CompanyShareValue> companyShareValues = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(generatedQuery);
            List list = query.list();
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                companyShareValues.add((CompanyShareValue) iterator.next());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return companyShareValues;
    }
}
