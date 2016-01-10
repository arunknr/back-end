package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.RegisterDAO;

@Component
public class RegisterService {

    private RegisterDAO registerDAO;

    @Autowired
    public RegisterService(RegisterDAO registerDAO) {
        this.registerDAO = registerDAO;
    }

    public boolean register(String username, String password, String firstname, String lastname, String email) {
        return registerDAO.register(username, password, firstname, lastname, email);
    }
}
