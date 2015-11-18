package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import shareForcast.DAO.RatioValueDAO;
import shareForcast.helper.QueryBuilder;
import shareForcast.model.ShareKeyword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QueryService {

    static HashMap<String, Integer> sharekeywordRatioIdMap;
    private RatioValueDAO ratioValueDAO;

    @Autowired
    public QueryService(KeywordService keywordService, RatioValueDAO ratioValueDAO) {
        this.ratioValueDAO = ratioValueDAO;

        createShareKeyWordRatioMap(keywordService);
    }

    private void createShareKeyWordRatioMap(KeywordService keywordService) {
        List<ShareKeyword> shareKeywords = keywordService.fetch();
        for (ShareKeyword shareKeyword : shareKeywords) {
            sharekeywordRatioIdMap.put(shareKeyword.getKeyword(), shareKeyword.getRatioId());
        }
    }

    public List<HashMap<String, String>> getValue(String query) {
        QueryBuilder queryBuilder = new QueryBuilder();
        String generatedQuery = queryBuilder.createQuery(query, sharekeywordRatioIdMap);
        ArrayList<String> keys = queryBuilder.getKeys(query, sharekeywordRatioIdMap);
        return ratioValueDAO.get(generatedQuery, keys);
    }
}
