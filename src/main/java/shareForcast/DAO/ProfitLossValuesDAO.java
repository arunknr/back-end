package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.model.ProfitLossAttributeValues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProfitLossValuesDAO {
    private final SessionFactory factory;

    @Autowired
    public ProfitLossValuesDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<ProfitLossAttributeValues> getAll(int companyId) {
        List<ProfitLossAttributeValues> profitLossValues = new ArrayList<>();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM ProfitLossAttributeValues where company_id=:companyId and report_period=201503")
                    .setInteger("companyId", companyId);
            List list = query.list();
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                profitLossValues.add((ProfitLossAttributeValues) iterator.next());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return profitLossValues;
    }

    public void insert(ProfitLossAttributeValues profitLossValues) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(profitLossValues);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(ProfitLossAttributeValues profitLossValues) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(profitLossValues);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
