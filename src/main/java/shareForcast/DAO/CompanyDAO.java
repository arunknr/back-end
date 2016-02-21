package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.model.CompanyInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CompanyDAO {
    private final SessionFactory factory;

    @Autowired
    public CompanyDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<CompanyInfo> getAll() {
        List<CompanyInfo> companyList = new ArrayList<>();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM CompanyInfo");
            List list = query.list();
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                companyList.add((CompanyInfo) iterator.next());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return companyList;
    }

    public void insert(CompanyInfo companyList) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(companyList);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(CompanyInfo companyList) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(companyList);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
