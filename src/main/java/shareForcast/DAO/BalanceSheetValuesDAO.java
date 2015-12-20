package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.model.BalanceSheetAttributeValues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class BalanceSheetValuesDAO {
    private final SessionFactory factory;

    @Autowired
    public BalanceSheetValuesDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<BalanceSheetAttributeValues> getAll(int companyId) {
        List<BalanceSheetAttributeValues> balanceSheetValues = new ArrayList<>();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM BalanceSheetAttributeValues where company_id=:companyId")
                    .setInteger("companyId", companyId);
            List list = query.list();
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                balanceSheetValues.add((BalanceSheetAttributeValues) iterator.next());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return balanceSheetValues;
    }

    public void insert(BalanceSheetAttributeValues balanceSheetValues) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(balanceSheetValues);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(BalanceSheetAttributeValues balanceSheetValues) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(balanceSheetValues);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
