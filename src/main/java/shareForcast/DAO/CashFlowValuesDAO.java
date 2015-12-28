package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.model.CashFlowAttributeValues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CashFlowValuesDAO {
    private final SessionFactory factory;

    @Autowired
    public CashFlowValuesDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<CashFlowAttributeValues> getAll(int companyId) {
        List<CashFlowAttributeValues> cashFlowValues = new ArrayList<>();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM CashFlowAttributeValues where company_id=:companyId")
                    .setInteger("companyId", companyId);
            List list = query.list();
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                cashFlowValues.add((CashFlowAttributeValues) iterator.next());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cashFlowValues;
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
