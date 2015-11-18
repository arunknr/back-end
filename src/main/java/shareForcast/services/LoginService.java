package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.LoginDAO;

@Component
public class LoginService {

    private LoginDAO loginDAO;

    @Autowired
    public LoginService(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public boolean login(String username, String password) {
        return loginDAO.exist(username, password);
    }
}
