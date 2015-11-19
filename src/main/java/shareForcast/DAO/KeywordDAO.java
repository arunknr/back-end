package shareForcast.DAO;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shareForcast.model.ShareKeyword;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class KeywordDAO {
    private final SessionFactory factory;

    @Autowired
    public KeywordDAO(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public List<ShareKeyword> getAll() {
        List<ShareKeyword> shareKeywords = new ArrayList<>();

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM ShareKeyword");
            List list = query.list();
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                shareKeywords.add((ShareKeyword) iterator.next());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return shareKeywords;
    }
}
