package shareForcast.services;

import shareForcast.DAO.RatioValueDAO;
import shareForcast.helper.QueryBuilder;
import shareForcast.model.ShareKeyword;

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

    public void getValue(String query) {
        String generatedQuery = new QueryBuilder().createQuery(query, sharekeywordRatioIdMap);
        new RatioValueDAO().get(generatedQuery);
    }
}
