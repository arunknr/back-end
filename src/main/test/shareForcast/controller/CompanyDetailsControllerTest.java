package shareForcast.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import shareForcast.model.CompanyInfo;
import shareForcast.services.CompanyInfoService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CompanyDetailsControllerTest {

    @Mock
    CompanyInfoService companyInfoServiceMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testIsServiceIsCalledWithRightParams() {
        CompanyDetailsController companyDetailsController = new CompanyDetailsController(companyInfoServiceMock);
        CompanyInfo companyInfo = new CompanyInfo();
        when(companyInfoServiceMock.get(anyInt())).thenReturn(companyInfo);

        assertEquals(companyInfo, companyDetailsController.getCompanyDetails(123));
        verify(companyInfoServiceMock, times(1)).get(123);
    }

}