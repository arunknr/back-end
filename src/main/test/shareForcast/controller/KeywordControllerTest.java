package shareForcast.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import shareForcast.model.ShareKeyword;
import shareForcast.services.KeywordService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class KeywordControllerTest {

    @Mock
    KeywordService keywordServiceMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testIsServiceIsCalledWithRightParams() {
        KeywordController keywordController = new KeywordController(keywordServiceMock);
        List<ShareKeyword> expectedValue = Arrays.asList(new ShareKeyword(1, "a", 1), new ShareKeyword(2, "b", 2));
        when(keywordServiceMock.fetch()).thenReturn(expectedValue);

        assertEquals(expectedValue, keywordController.fetchKeyWords().getShareKeywordList());
        verify(keywordServiceMock, times(1)).fetch();
    }

}