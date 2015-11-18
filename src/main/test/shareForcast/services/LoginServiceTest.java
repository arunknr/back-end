package shareForcast.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import shareForcast.DAO.LoginDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginServiceTest {

    @Mock
    LoginDAO loginDAOMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testIfDAOAreCalledWithRightParams() {
        LoginService loginService = new LoginService(loginDAOMock);
        String username = "user";
        String password = "password";

        when(loginDAOMock.exist(username, password)).thenReturn(true);

        assertEquals(true, loginService.login(username, password));
        verify(loginDAOMock, times(1)).exist(username, password);
    }
}