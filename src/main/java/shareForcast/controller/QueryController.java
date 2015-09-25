package shareForcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.CompanyShareValue;
import shareForcast.services.QueryService;
import java.util.List;

@RestController
public class QueryController {

    @RequestMapping(value="/query", method= RequestMethod.GET)
    public List<CompanyShareValue> getResultForQuery(@RequestParam(value = "query") String query) {
        QueryService queryService = new QueryService();
        return queryService.getResultForQuery(query);
    }
}