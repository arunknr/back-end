package shareForcast.services;

import shareForcast.DAO.RatioValueDAO;
import shareForcast.helper.QueryBuilder;
import shareForcast.model.ShareKeyword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class QueryService {
    HashMap<String, Integer> sharekeywordRatioIdMap;

    public QueryService() {
        List<ShareKeyword> shareKeywords = new KeywordService().fetch();
        for (ShareKeyword shareKeyword : shareKeywords) {
            sharekeywordRatioIdMap.put(shareKeyword.getKeyword(), shareKeyword.getRatioId());
        }
    }

    public List<HashMap<String, String>> getValue(String query) {
        QueryBuilder queryBuilder = new QueryBuilder();
        String generatedQuery = queryBuilder.createQuery(query, sharekeywordRatioIdMap);
        ArrayList<String> keys = queryBuilder.getKeys(query, sharekeywordRatioIdMap);
        return new RatioValueDAO().get(generatedQuery, keys);
    }
}
