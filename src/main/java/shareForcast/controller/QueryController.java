package shareForcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    @RequestMapping(value="/query", method= RequestMethod.GET)
    public void getResultForQuery(@RequestParam(value = "query") String query) {

    }
}