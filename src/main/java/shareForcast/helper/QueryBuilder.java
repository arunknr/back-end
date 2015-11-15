package shareForcast.helper;

import java.util.HashMap;

public class QueryBuilder {

    public String createQuery(String query, HashMap<String, Integer> shareKeywords) {
        query = query.toLowerCase().trim();
        String[] queryStrings = query.split(" ");
        StringBuilder queryStringBuilder = new StringBuilder();
        queryStringBuilder.append("select * from ");

        StringBuilder whereQueryBuilder = new StringBuilder();
        whereQueryBuilder.append(" where").append(" ");

        int ratioQueryCounter = 0;

        for (String queryString : queryStrings) {
            if(shareKeywords.containsKey(queryString) && shareKeywords.get(queryString) != null) {

                Integer ratioId = shareKeywords.get(queryString);
                ratioQueryCounter++;

                if(ratioQueryCounter > 1)
                    queryStringBuilder.append(" join");
                queryStringBuilder
                        .append(" (select company_id, ratio_value as ratio").append(ratioQueryCounter)
                        .append(" from RATIOVALUES where ratio_id = ").append(ratioId).append(") as t").append(ratioQueryCounter);
                if(ratioQueryCounter > 1){
                    queryStringBuilder
                            .append(" on t1.company_id = t").append(ratioQueryCounter).append(".company_id");
                }

                whereQueryBuilder
                        .append(" ratio").append(ratioQueryCounter);

            }else {
                whereQueryBuilder
                        .append(" ").append(queryString);
            }
        }

        return queryStringBuilder.append(whereQueryBuilder.toString()).toString();
    }
}