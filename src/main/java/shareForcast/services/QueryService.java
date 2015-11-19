package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.RatioValueDAO;
import shareForcast.helper.QueryBuilder;
import shareForcast.model.ShareKeyword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class QueryService {

    static HashMap<String, Integer> sharekeywordRatioIdMap = new HashMap<>();
    private KeywordService keywordService;
    private RatioValueDAO ratioValueDAO;

    @Autowired
    public QueryService(KeywordService keywordService, RatioValueDAO ratioValueDAO) {
        this.keywordService = keywordService;
        this.ratioValueDAO = ratioValueDAO;
    }

    private void createShareKeyWordRatioMap(KeywordService keywordService) {
        List<ShareKeyword> shareKeywords = keywordService.fetch();
        for (ShareKeyword shareKeyword : shareKeywords) {
            sharekeywordRatioIdMap.put(shareKeyword.getKeyword(), shareKeyword.getRatioId());
        }
    }

    public List<HashMap<String, String>> getValue(String query) {
        if(sharekeywordRatioIdMap.isEmpty())
            createShareKeyWordRatioMap(keywordService);

        String generatedQuery = QueryBuilder.createQuery(query, sharekeywordRatioIdMap);
        ArrayList<String> keys = QueryBuilder.getKeys(query, sharekeywordRatioIdMap);
        return ratioValueDAO.get(generatedQuery, keys);
    }
}
