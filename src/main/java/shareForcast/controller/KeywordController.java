package shareForcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shareForcast.model.reqResModels.KeywordsResponse;
import shareForcast.services.KeywordService;

@RestController
public class KeywordController {

    private KeywordService keywordService;

    @Autowired
    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @RequestMapping(value="/keywords", method= RequestMethod.GET)
    public KeywordsResponse fetchKeyWords() {
        return new KeywordsResponse(keywordService.fetch());
    }
}
