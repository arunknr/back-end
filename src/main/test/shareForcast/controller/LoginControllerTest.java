package shareForcast.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import shareForcast.model.reqResModels.LoginResponse;
import shareForcast.services.LoginService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginControllerTest {

    @Mock
    LoginService loginServiceMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testIsServiceIsCalledWithRightParams() {
        LoginController loginController = new LoginController(loginServiceMock);
        String username = "user";
        String password = "password";
        when(loginServiceMock.login(username, password)).thenReturn(true);

        assertEquals(true, loginController.login(username, password).isLoggedIn());
        verify(loginServiceMock, times(1)).login(username, password);
    }

}