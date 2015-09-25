package shareForcast.helper;

import java.util.HashMap;
import java.util.Map;

public class QueryBuilder {
    static HashMap<String, String> keyWordColumnMap = new HashMap<>();

    public QueryBuilder() {
        keyWordColumnMap.put("face value", "faceValue");
        keyWordColumnMap.put("market cap", "marketCap");
    }

    public String createQuery(String query) {
        query = query.toLowerCase().trim();
        StringBuilder queryStringBuilder = new StringBuilder();
        queryStringBuilder.append("FROM CompanyShareValue")
                .append(" ")
                .append("WHERE")
                .append(" ")
                .append(transformQuery(query));
        return queryStringBuilder.toString();
    }

    private String transformQuery(String query) {
        for (Map.Entry<String, String> entry : keyWordColumnMap.entrySet()) {
            query = query.replace(entry.getKey(), entry.getValue());
        }
        return query;
    }
}