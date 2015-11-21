package shareForcast.DAO;

import org.junit.*;
import shareForcast.model.CompanyInfo;
import shareForcast.util.HibernateUtil;

import static org.junit.Assert.assertEquals;

public class CompanyInfoDAOIntegrationTest {

    private static CompanyInfoDAO companyInfoDAO;
    private static CompanyInfo companyInfoTestData;

    @BeforeClass
    public static void setUp(){
        companyInfoDAO = new CompanyInfoDAO(HibernateUtil.getSessionFactory());
        companyInfoTestData = new CompanyInfo(1, 123, 345, "test id", "test company", true, true, "test group", "test market");
    }

    @AfterClass
    public static void tearDown(){
        HibernateUtil.shutdown();
    }

    @Test
    public void testIfAbleToInsertAndFetchCompanyInfo() {
        companyInfoDAO.insert(companyInfoTestData);

        CompanyInfo companyInfo = companyInfoDAO.get(123, 1);

        assertEquals(companyInfoTestData, companyInfo);

        companyInfoDAO.delete(companyInfoTestData);
    }

    @Test
    public void testAbleToDeleteAfterInsert(){
        companyInfoDAO.insert(companyInfoTestData);

        companyInfoDAO.delete(companyInfoTestData);

        CompanyInfo companyInfo = companyInfoDAO.get(123, 1);

        assertEquals(null, companyInfo);
    }
}