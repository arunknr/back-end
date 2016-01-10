package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.helper.ProfitLossValueResponseTransformer;
import shareForcast.model.ProfitLossAttributeValues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProfitLossValuesDAO {
    private final SessionFactory factory;

    @Autowired
    public ProfitLossValuesDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<HashMap<String, Object>> getAll(int companyId, int reportPeriod) {
        List<ProfitLossAttributeValues> profitLossValues = new ArrayList<>();

        Session session = factory.openSession();
        Transaction tx = null;
        List<HashMap<String, Object>> returnValue = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM ProfitLossAttributeValues where company_id=:companyId and report_period>:reportPeriod1 and report_period<:reportPeriod2 order by id, report_period");
            query.setInteger("companyId", companyId);
            query.setInteger("reportPeriod1", reportPeriod - 500);
            query.setInteger("reportPeriod2", reportPeriod + 100);
            List list = query.list();
            /*Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                profitLossValues.add((ProfitLossAttributeValues) iterator.next());
            }*/
            tx.commit();
            returnValue = ProfitLossValueResponseTransformer.processResponseForProfitLossValueQuery(list);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return returnValue;
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
