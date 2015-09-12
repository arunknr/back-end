package shareForcast.services;

import org.springframework.stereotype.Component;
import shareForcast.DAO.LoginDAO;

@Component
public class LoginService {
    public boolean login(String username, String password) {
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.exist(username, password);
    }
}
