package shareForcast.DAO;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import shareForcast.model.User;
import shareForcast.util.HibernateUtil;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginDAOIntegrationTest {

    private static LoginDAO loginDAO;

    @BeforeClass
    public static void setUp(){
        loginDAO = new LoginDAO(HibernateUtil.getSessionFactory());
    }

    @AfterClass
    public static void tearDown(){
        HibernateUtil.shutdown();
    }

    @Test
    public void testIfAbleToInsertAndCheckIfUserAndPasswordExistInDB() {
        String userName = "testuser";
        String password = "testpassword";
        User testuser = new User(userName, password);
        loginDAO.insert(testuser);

        assertTrue(loginDAO.exist(userName, password));

        assertFalse(loginDAO.exist("randomUser", "randomPassword"));

        loginDAO.delete(testuser);
    }

    @Test
    public void testifDeleteIsHappeningProperly(){
        String userName = "testuser";
        String password = "testpassword";
        User testuser = new User(userName, password);
        loginDAO.insert(testuser);

        loginDAO.delete(testuser);

        assertFalse(loginDAO.exist(userName, password));
    }
}