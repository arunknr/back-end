package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.helper.BalanceSheetValueResponseTransformer;
import shareForcast.model.BalanceSheetAttributeValues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BalanceSheetValuesDAO {
    private final SessionFactory factory;

    @Autowired
    public BalanceSheetValuesDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<HashMap<String, Object>> getAll(int companyId, int reportPeriod) {
        List<BalanceSheetAttributeValues> balanceSheetValues = new ArrayList<>();

        Session session = factory.getCurrentSession();
        List<HashMap<String, Object>> returnValue = null;

        try {
            Query query = session.createQuery("FROM BalanceSheetAttributeValues where company_id=:companyId and report_period>:reportPeriod1 and report_period<:reportPeriod2 order by id, report_period");
            query.setInteger("companyId", companyId);
            query.setInteger("reportPeriod1", reportPeriod - 500);
            query.setInteger("reportPeriod2", reportPeriod + 100);
            List list = query.list();
            /*Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                balanceSheetValues.add((BalanceSheetAttributeValues) iterator.next());
            }*/
            returnValue = BalanceSheetValueResponseTransformer.processResponseForBalanceSheetValueQuery(list);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return returnValue;
    }

    public void insert(BalanceSheetAttributeValues balanceSheetValues) {
        Session session = factory.getCurrentSession();
        try {
            session.saveOrUpdate(balanceSheetValues);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void delete(BalanceSheetAttributeValues balanceSheetValues) {
        Session session = factory.getCurrentSession();
        try {
            session.delete(balanceSheetValues);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
