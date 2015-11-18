package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.reqResModels.LoginResponse;
import shareForcast.services.LoginService;

@RestController
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public LoginResponse login(@RequestParam(value = "username", defaultValue = "World") String username, @RequestParam(value = "password", defaultValue = "World") String password) {
        return new LoginResponse(loginService.login(username, password));
    }
}