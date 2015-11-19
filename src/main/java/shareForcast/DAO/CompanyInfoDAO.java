package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.model.CompanyInfo;

@Repository
public class CompanyInfoDAO {
    private final SessionFactory factory;

    @Autowired
    public CompanyInfoDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public CompanyInfo get(int accordId, int companyId) {
        Session session = factory.openSession();
        Transaction tx = null;
        CompanyInfo companyInfo = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM CompanyInfo where company_id=:companyId and accord_id=:accordId")
                    .setInteger("companyId", companyId)
                    .setInteger("accordId", accordId);
            companyInfo = (CompanyInfo) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return companyInfo;
    }
}
