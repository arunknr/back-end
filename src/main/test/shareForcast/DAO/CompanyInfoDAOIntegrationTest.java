package shareForcast.DAO;

import org.junit.Before;
import org.junit.Test;
import shareForcast.model.CompanyInfo;
import shareForcast.util.HibernateUtil;

import static org.junit.Assert.assertEquals;

public class CompanyInfoDAOIntegrationTest {

    private CompanyInfoDAO companyInfoDAO;
    private CompanyInfo companyInfoTestData;

    @Before
    public void setUp(){
        companyInfoDAO = new CompanyInfoDAO(HibernateUtil.getSessionFactory());
        companyInfoTestData = new CompanyInfo(1, 123, 345, "test id", "test company", true, true, "test group", "test market");
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