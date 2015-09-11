package shareForcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public LoginResponse login(@RequestParam(value = "username", defaultValue = "World") String username, @RequestParam(value = "password", defaultValue = "World") String password) {
        if(username.equals("1") && password.equals("arun"))
            return new LoginResponse(true);
        return new LoginResponse(false);
    }

    class LoginResponse{
        boolean isLoggedIn;

        public LoginResponse(boolean isLoggedIn) {

            this.isLoggedIn = isLoggedIn;
        }

        public boolean isLoggedIn() {
            return isLoggedIn;
        }

        public void setIsLoggedIn(boolean isLoggedIn) {
            this.isLoggedIn = isLoggedIn;
        }
    }
}