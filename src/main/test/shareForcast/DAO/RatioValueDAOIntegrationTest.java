package shareForcast.DAO;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import shareForcast.model.RatioAttributeValues;
import shareForcast.model.RatioAttributeValuesPk;
import shareForcast.util.HibernateUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static junit.framework.Assert.*;

public class RatioValueDAOIntegrationTest {
    private static RatioValueDAO ratioValueDAO;

    @BeforeClass
    public static void setUp(){
        ratioValueDAO = new RatioValueDAO(HibernateUtil.getSessionFactory());
    }

    @Test
    public void testIfAbleToInsertAndFetchCompanyInfo() {
        RatioAttributeValues ratioAttributeValues1 = new RatioAttributeValues(new RatioAttributeValuesPk(1, 1, 1, 8000), 10);
        ratioValueDAO.insert(ratioAttributeValues1);

        RatioAttributeValues ratioAttributeValues2 = new RatioAttributeValues(new RatioAttributeValuesPk(2, 1, 1, 8001), 20);
        ratioValueDAO.insert(ratioAttributeValues2);

        RatioAttributeValues ratioAttributeValues3 = new RatioAttributeValues(new RatioAttributeValuesPk(3, 1, 1, 8002), 30);
        ratioValueDAO.insert(ratioAttributeValues3);

        RatioAttributeValues ratioAttributeValues4 = new RatioAttributeValues(new RatioAttributeValuesPk(1, 1, 1, 8000), 40);
        ratioValueDAO.insert(ratioAttributeValues4);

        RatioAttributeValues ratioAttributeValues5 = new RatioAttributeValues(new RatioAttributeValuesPk(2, 1, 1, 8001), 50);
        ratioValueDAO.insert(ratioAttributeValues5);

        RatioAttributeValues ratioAttributeValues6 = new RatioAttributeValues(new RatioAttributeValuesPk(3, 1, 1, 8002), 60);
        ratioValueDAO.insert(ratioAttributeValues6);

        RatioAttributeValues ratioAttributeValues7 = new RatioAttributeValues(new RatioAttributeValuesPk(1, 1, 1, 8000), 70);
        ratioValueDAO.insert(ratioAttributeValues7);

        RatioAttributeValues ratioAttributeValues8 = new RatioAttributeValues(new RatioAttributeValuesPk(2, 1, 1, 8001), 80);
        ratioValueDAO.insert(ratioAttributeValues8);

        RatioAttributeValues ratioAttributeValues9 = new RatioAttributeValues(new RatioAttributeValuesPk(3, 1, 1, 8002), 90);
        ratioValueDAO.insert(ratioAttributeValues9);

        String testQuery = "select t1.company_id, t1.time_id, t1.report_period, ratio1, ratio2, ratio3 from \n" +
                "(select company_id,time_id, report_period, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1) as t1\n" +
                "join (select company_id,time_id, report_period, ratio_value as ratio2 from RATIOVALUES where ratio_id = 2) as t2 on t1.company_id = t2.company_id and t1.time_id = t2.time_id and t1.report_period=t2.report_period\n" +
                "join (select company_id,time_id, report_period, ratio_value as ratio3 from RATIOVALUES where ratio_id = 3) as t3 on t1.company_id = t3.company_id and t1.time_id = t3.time_id and t1.report_period=t3.report_period\n" +
                "where ratio1 >20 and ratio2 > 10 or ratio3 < 80;";

        List<HashMap<String, String>> hashMapList = ratioValueDAO.get(testQuery,
                Arrays.asList("CompanyId", "TimeId", "ReportPeriod", "TestRatio1", "TestRatio2", "TestRatio3"));

        assertEquals(3, hashMapList.size());
        assertEquals(6, hashMapList.get(0).size());
        assertEquals(6, hashMapList.get(1).size());
        assertEquals(6, hashMapList.get(2).size());

        ratioValueDAO.delete(ratioAttributeValues1);
        ratioValueDAO.delete(ratioAttributeValues2);
        ratioValueDAO.delete(ratioAttributeValues3);
        ratioValueDAO.delete(ratioAttributeValues4);
        ratioValueDAO.delete(ratioAttributeValues5);
        ratioValueDAO.delete(ratioAttributeValues6);
        ratioValueDAO.delete(ratioAttributeValues7);
        ratioValueDAO.delete(ratioAttributeValues8);
        ratioValueDAO.delete(ratioAttributeValues9);
    }

    @Test
    public void testAbleToInsertAndDelete() {
        RatioAttributeValues ratioAttributeValues = new RatioAttributeValues(new RatioAttributeValuesPk(1, 1, 1, 8000), 10);
        ratioValueDAO.insert(ratioAttributeValues);

        ratioValueDAO.delete(ratioAttributeValues);

        List<HashMap<String, String>> hashMapList = ratioValueDAO.get("select company_id, time_id, report_period, ratio_value from RATIOVALUES where ratio_id = 8000",
                Arrays.asList("CompanyId", "TimeId", "ReportPeriod", "RatioValue"));

        assertEquals(0, hashMapList.size());
    }

}