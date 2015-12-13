package shareForcast.helper;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class QueryBuilderTest {
    private HashMap<String, Integer> hashMap;

    @Before
    public void setup(){
        hashMap = new HashMap<>();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);
        hashMap.put("d", 4);
        hashMap.put("e", 5);
        hashMap.put(">", null);
        hashMap.put("<", null);
        hashMap.put("and", null);
        hashMap.put("or", null);
        hashMap.put(">=", null);
        hashMap.put("<=", null);
    }

    @Test
    public void testQueryCreatedProperlyForMultipleConditions(){

        String expectedQuery ="select r1.company_id, r3.company_name, r2.name, r1.ratio_value from RATIOVALUES as r1 " +
                "join (select id, name  from RATIOS) as r2 " +
                "on r1.ratio_id = r2.id " +
                "join (select company_name, company_id  from COMPANYINFORMATION) as r3 " +
                "on r1.company_id = r3.company_id " +
                "where r1.company_id in (" +
                "select distinct t1.company_id " +
                "from (select company_id, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1 and time_id = 5 and report_period = 201503) as t1 " +
                "join (select company_id, ratio_value as ratio2 from RATIOVALUES where ratio_id = 2 and time_id = 5 and report_period = 201503) as t2 " +
                "on t1.company_id = t2.company_id " +
                "join (select company_id, ratio_value as ratio3 from RATIOVALUES where ratio_id = 3 and time_id = 5 and report_period = 201503) as t3 " +
                "on t1.company_id = t3.company_id " +
                "where ( ratio1 > 20 and ratio2 > 10 ) or ( ratio3 < 100 )) and time_id = 5 and report_period = 201503";

        String query = "( a > 20 and b > 10 ) or ( c < 100 )";
        String actualQuery = QueryBuilder.createQuery(query, hashMap);

        assertEquals(expectedQuery, actualQuery);
    }


    @Test
    public void testForOneRatio(){
        String expectedQuery = "select r1.company_id, r3.company_name, r2.name, r1.ratio_value from RATIOVALUES as r1 " +
                "join (select id, name  from RATIOS) as r2 " +
                "on r1.ratio_id = r2.id " +
                "join (select company_name, company_id  from COMPANYINFORMATION) as r3 " +
                "on r1.company_id = r3.company_id " +
                "where r1.company_id in (" +
                "select distinct t1.company_id " +
                "from (select company_id, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1 and time_id = 5 and report_period = 201503) as t1 " +
                "where ratio1 > 20) and time_id = 5 and report_period = 201503";

        String query = "a > 20";
        String actualQuery = QueryBuilder.createQuery(query, hashMap);

        assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testForTwoRatio(){
        String expectedQuery ="select r1.company_id, r3.company_name, r2.name, r1.ratio_value from RATIOVALUES as r1 " +
                "join (select id, name  from RATIOS) as r2 " +
                "on r1.ratio_id = r2.id " +
                "join (select company_name, company_id  from COMPANYINFORMATION) as r3 " +
                "on r1.company_id = r3.company_id " +
                "where r1.company_id in (" +
                "select distinct t1.company_id " +
                "from (select company_id, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1 and time_id = 5 and report_period = 201503) as t1 " +
                "join (select company_id, ratio_value as ratio2 from RATIOVALUES where ratio_id = 2 and time_id = 5 and report_period = 201503) as t2 " +
                "on t1.company_id = t2.company_id " +
                "where ratio1 > 20 or ratio2 = 8) and time_id = 5 and report_period = 201503";

        String query = "a > 20 or b = 8";
        String actualQuery = QueryBuilder.createQuery(query, hashMap);

        assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testForTwoRatioExtended(){
        String expectedQuery ="select r1.company_id, r3.company_name, r2.name, r1.ratio_value from RATIOVALUES as r1 " +
                "join (select id, name  from RATIOS) as r2 " +
                "on r1.ratio_id = r2.id " +
                "join (select company_name, company_id  from COMPANYINFORMATION) as r3 " +
                "on r1.company_id = r3.company_id " +
                "where r1.company_id in (" +
                "select distinct t1.company_id " +
                "from (select company_id, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1 and time_id = 5 and report_period = 201503) as t1 " +
                "join (select company_id, ratio_value as ratio2 from RATIOVALUES where ratio_id = 2 and time_id = 5 and report_period = 201503) as t2 " +
                "on t1.company_id = t2.company_id " +
                "where ratio1 > 20 and ratio2 >= 8) and time_id = 5 and report_period = 201503";

        String query = "a > 20 and b >= 8";
        String actualQuery = QueryBuilder.createQuery(query, hashMap);

        assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testForMultipleRatios(){
        String expectedQuery ="select r1.company_id, r3.company_name, r2.name, r1.ratio_value from RATIOVALUES as r1 " +
                "join (select id, name  from RATIOS) as r2 " +
                "on r1.ratio_id = r2.id " +
                "join (select company_name, company_id  from COMPANYINFORMATION) as r3 " +
                "on r1.company_id = r3.company_id " +
                "where r1.company_id in (" +
                "select distinct t1.company_id " +
                "from (select company_id, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1 and time_id = 5 and report_period = 201503) as t1 " +
                "join (select company_id, ratio_value as ratio2 from RATIOVALUES where ratio_id = 2 and time_id = 5 and report_period = 201503) as t2 " +
                "on t1.company_id = t2.company_id " +
                "join (select company_id, ratio_value as ratio3 from RATIOVALUES where ratio_id = 3 and time_id = 5 and report_period = 201503) as t3 " +
                "on t1.company_id = t3.company_id " +
                "join (select company_id, ratio_value as ratio4 from RATIOVALUES where ratio_id = 4 and time_id = 5 and report_period = 201503) as t4 " +
                "on t1.company_id = t4.company_id " +
                "join (select company_id, ratio_value as ratio5 from RATIOVALUES where ratio_id = 5 and time_id = 5 and report_period = 201503) as t5 " +
                "on t1.company_id = t5.company_id " +
                "where ( ratio1 > 20 and ratio2 >= 8 ) or ( ratio3 = 10 ) and ( ratio4 <= 1 ) or ratio5 = 5) " +
                "and time_id = 5 and report_period = 201503";

        String query = "( a > 20 and b >= 8 ) or ( c = 10 ) and ( d <= 1 ) or e = 5";
        String actualQuery = QueryBuilder.createQuery(query, hashMap);

        assertEquals(expectedQuery, actualQuery);
    }
    //TODO: write more test to cover all conditions
}