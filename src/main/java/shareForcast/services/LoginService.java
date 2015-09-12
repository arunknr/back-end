package shareForcast.services;

import org.springframework.stereotype.Component;
import shareForcast.DAO.LoginDAO;
import shareForcast.model.reqResModels.LoginResponse;

@Component
public class LoginService {
    public LoginResponse login(String username, String password) {
        LoginDAO loginDAO = new LoginDAO();
        return new LoginResponse(loginDAO.exist(username, password));
    }
}
