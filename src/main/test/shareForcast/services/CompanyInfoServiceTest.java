package shareForcast.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import shareForcast.DAO.CompanyInfoDAO;
import shareForcast.model.CompanyInfo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CompanyInfoServiceTest {

    @Mock
    CompanyInfoDAO companyInfoDAOMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testIfDAOAreCalledWithRightParams() {
        CompanyInfoService companyInfoService = new CompanyInfoService(companyInfoDAOMock);
        CompanyInfo expectedValue = new CompanyInfo();
        when(companyInfoDAOMock.get(123, 123)).thenReturn(expectedValue);

        assertEquals(expectedValue, companyInfoService.get(123, 123));
        verify(companyInfoDAOMock, times(1)).get(123, 123);
    }

}