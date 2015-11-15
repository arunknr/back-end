package shareForcast.helper;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class QueryBuilderTest {
    private QueryBuilder queryBuilder;
    private HashMap<String, Integer> hashMap;

    @Before
    public void setup(){
        queryBuilder = new QueryBuilder();
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

        String expectedQuery ="select * from (select company_id, ratio_value as ratio1 from RATIOVALUES where ratio_id = 1) as t1 " +
                "join (select company_id, ratio_value as ratio2 from RATIOVALUES where ratio_id = 2) as t2 " +
                "on t1.company_id = t2.company_id" +
                " join (select company_id, ratio_value as ratio3 from RATIOVALUES where ratio_id = 3) as t3 " +
                "on t1.company_id = t3.company_id " +
                "where ( ratio1 > 20  and ratio2 > 10 ) or ( ratio3 < 100 )";
        String query = queryBuilder.createQuery("( a > 20 and b > 10 ) or ( c < 100 )", hashMap);

        assertEquals(expectedQuery, query);
    }
}