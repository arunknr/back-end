package shareForcast.DAO;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import shareForcast.model.ShareKeyword;
import shareForcast.util.HibernateUtil;

import java.util.List;

import static org.junit.Assert.*;

public class KeywordDAOTest {

    private static KeywordDAO keywordDAO;

    @BeforeClass
    public static void setUp(){
        keywordDAO = new KeywordDAO(HibernateUtil.getSessionFactory());
    }

    @AfterClass
    public static void tearDown(){
        HibernateUtil.shutdown();
    }

    @Test
    public void testIfAbleToInsertAndFetchAllKeywords() {
        ShareKeyword shareKeyword1 = new ShareKeyword(8000, "test1", 1);
        keywordDAO.insert(shareKeyword1);
        ShareKeyword shareKeyword2 = new ShareKeyword(8001, "test2", 2);
        keywordDAO.insert(shareKeyword2);
        ShareKeyword shareKeyword3 = new ShareKeyword(8002, "test3", 3);
        keywordDAO.insert(shareKeyword3);

        List<ShareKeyword> shareKeywordList = keywordDAO.getAll();

        assertTrue(shareKeywordList.size() > 3);

        assertTrue(shareKeywordList.contains(shareKeyword1));
        assertTrue(shareKeywordList.contains(shareKeyword2));
        assertTrue(shareKeywordList.contains(shareKeyword3));

        keywordDAO.delete(shareKeyword1);
        keywordDAO.delete(shareKeyword2);
        keywordDAO.delete(shareKeyword3);
    }

    @Test
    public void testdeleteIsDeletingValues() {
        ShareKeyword shareKeyword1 = new ShareKeyword(8000, "test1", 1);
        keywordDAO.insert(shareKeyword1);

        keywordDAO.delete(shareKeyword1);

        List<ShareKeyword> shareKeywordList = keywordDAO.getAll();
        assertFalse(shareKeywordList.contains(shareKeyword1));
    }

}