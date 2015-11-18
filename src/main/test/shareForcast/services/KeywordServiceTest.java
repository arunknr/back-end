package shareForcast.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import shareForcast.DAO.KeywordDAO;
import shareForcast.model.ShareKeyword;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class KeywordServiceTest {

    @Mock
    KeywordDAO keywordDAOMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testIfDAOAreCalledWithRightParams() {
        KeywordService keywordService = new KeywordService(keywordDAOMock);
        List<ShareKeyword> expectedValue = new ArrayList<>();
        when(keywordDAOMock.getAll()).thenReturn(expectedValue);

        assertEquals(expectedValue, keywordService.fetch());
        verify(keywordDAOMock, times(1)).getAll();
    }
}