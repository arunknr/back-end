package shareForcast.DAO;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import shareForcast.model.CompanyInfo;

public class CompanyInfoDAO {
    private final SessionFactory factory;

    public CompanyInfoDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public CompanyInfo get(int accordId, int shianId) {
        Session session = factory.openSession();
        Transaction tx = null;
        CompanyInfo companyInfo = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM CompanyInfo where shian_id=:shianId and accord_id=:accordId")
                    .setInteger("shianId", shianId)
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
