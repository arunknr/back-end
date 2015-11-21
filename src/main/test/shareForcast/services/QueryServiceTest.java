package shareForcast.services;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import shareForcast.DAO.RatioValueDAO;
import shareForcast.model.ShareKeyword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class QueryServiceTest {

    @Mock
    KeywordService keywordServiceMock;

    @Mock
    RatioValueDAO ratioValueDAOMock;

    @Before
    public void setUp(){
        initMocks(this);
        when(keywordServiceMock.fetch()).thenReturn(Arrays.asList(new ShareKeyword(1, "market", 2)));
    }

    @Test
    public void testIfDAOAreCalledWithRightParams() {
        String expectedSqlQuery = "select t1.company_id, t1.time_id, t1.report_period, ratio1 from (select company_id, time_id, report_period, ratio_value as ratio1 from RATIOVALUES where ratio_id = 2) as t1 where ratio1 > 10";
        QueryService loginService = new QueryService(keywordServiceMock, ratioValueDAOMock);
        List expectedvalue = new ArrayList();
        when(ratioValueDAOMock.get(anyString(), anyList())).thenReturn(expectedvalue);

        String query = "market > 10";
        List<HashMap<String, String>> value = loginService.getValue(query);

        assertEquals(expectedvalue, value);

        verify(ratioValueDAOMock, times(1)).get(expectedSqlQuery, Arrays.asList("market"));
    }

}