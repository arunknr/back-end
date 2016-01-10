package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.helper.CashFlowValueResponseTransformer;
import shareForcast.model.CashFlowAttributeValues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CashFlowValuesDAO {
    private final SessionFactory factory;

    @Autowired
    public CashFlowValuesDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<HashMap<String, Object>> getAll(int companyId, int reportPeriod) {
        List<CashFlowAttributeValues> cashFlowValues = new ArrayList<>();

        Session session = factory.openSession();
        Transaction tx = null;
        List<HashMap<String, Object>> returnValue = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM CashFlowAttributeValues where company_id=:companyId and report_period>:reportPeriod1 and report_period<:reportPeriod2 order by id, report_period");
            query.setInteger("companyId", companyId);
            query.setInteger("reportPeriod1", reportPeriod - 500);
            query.setInteger("reportPeriod2", reportPeriod + 100);
            List list = query.list();
            /*Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                cashFlowValues.add((CashFlowAttributeValues) iterator.next());
            }*/
            tx.commit();
            returnValue = CashFlowValueResponseTransformer.processResponseForCashFlowValueQuery(list);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return returnValue;
    }

    public void insert(CashFlowAttributeValues cashFlowValues) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(cashFlowValues);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(CashFlowAttributeValues cashFlowValues) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(cashFlowValues);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
