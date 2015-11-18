package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.services.QueryService;

import java.util.HashMap;
import java.util.List;

@RestController
public class QueryController {

    private QueryService queryService;

    @Autowired
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @RequestMapping(value="/query", method= RequestMethod.GET)
    public List<HashMap<String, String>> getResultForQuery(@RequestParam(value = "query") String query) {
        return queryService.getValue(query);
    }
}