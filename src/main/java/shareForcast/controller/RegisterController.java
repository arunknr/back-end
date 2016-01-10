package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.reqResModels.RegisterResponse;
import shareForcast.services.RegisterService;

@RestController
public class RegisterController {

    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @RequestMapping(value="/register", method= RequestMethod.GET)
    public RegisterResponse register(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,
                                  @RequestParam(value = "firstname") String firstname, @RequestParam(value = "lastname") String lastname,
                                  @RequestParam(value = "email") String email) {
        return new RegisterResponse(registerService.register(username, password, firstname, lastname, email));
    }
}