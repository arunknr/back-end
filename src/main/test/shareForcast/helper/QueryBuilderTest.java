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
        hashMap.put(">", null);
        hashMap.put("<", null);
        hashMap.put("and", null);
        hashMap.put("or", null);
    }

    @Test
    public void testQueryCreatedProperlyForMultipleConditions(){

        String expectedQuery ="select t1.company_id, t1.time_id, t1.report_period, ratio1, ratio2, ratio3 " +
                "from (select company_id, time_id, report_period, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1) as t1 " +
                "join (select company_id, time_id, report_period, ratio_value as ratio2 from RATIOVALUES where ratio_id = 2) as t2 " +
                "on t1.company_id = t2.company_id and t1.time_id = t2.time_id and t1.report_period = t2.report_period " +
                "join (select company_id, time_id, report_period, ratio_value as ratio3 from RATIOVALUES where ratio_id = 3) as t3 " +
                "on t1.company_id = t3.company_id and t1.time_id = t3.time_id and t1.report_period = t3.report_period " +
                "where ( ratio1 > 20 and ratio2 > 10 ) or ( ratio3 < 100 )";

        String query = "( a > 20 and b > 10 ) or ( c < 100 )";
        String actualQuery = QueryBuilder.createQuery(query, hashMap);

        assertEquals(expectedQuery, actualQuery);
    }


    @Test
    public void testForOneRatio(){
        String expectedQuery = "select t1.company_id, t1.time_id, t1.report_period, ratio1 " +
                "from (select company_id, time_id, report_period, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1) as t1 " +
                "where ratio1 > 20";

        String query = "a > 20";
        String actualQuery = QueryBuilder.createQuery(query, hashMap);

        assertEquals(expectedQuery, actualQuery);
    }

    //TODO: write more test to cover all conditions
}