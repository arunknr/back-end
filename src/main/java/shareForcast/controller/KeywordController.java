package shareForcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.reqResModels.KeywordsResponse;
import shareForcast.services.KeywordService;

@RestController
public class KeywordController {

    @RequestMapping(value="/keywords", method= RequestMethod.GET)
    public KeywordsResponse fetchKeyWords() {
        KeywordService keywordService = new KeywordService();
        return new KeywordsResponse(keywordService.fetch());
    }
}
