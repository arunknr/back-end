package shareForcast.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import shareForcast.model.ShareKeyword;
import shareForcast.services.QueryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class QueryControllerTest {

    @Mock
    QueryService queryServiceMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testIsServiceIsCalledWithRightParams() {
        QueryController queryController = new QueryController(queryServiceMock);
        String query = "query";
        List<HashMap<String, String>> expectedValue = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "two");
        expectedValue.add(map);

        when(queryServiceMock.getValue(query)).thenReturn(expectedValue);

        assertEquals(expectedValue, queryController.getResultForQuery(query));
        verify(queryServiceMock, times(1)).getValue(query);
    }

}