package shareForcast.helper;

import java.util.ArrayList;
import java.util.HashMap;

public class QueryBuilder {

    public static String createQuery(String query, HashMap<String, Integer> shareKeywords) {
        query = query.toLowerCase().trim();
        String[] queryStrings = query.split(" ");
        StringBuilder selectqueryBuilder = new StringBuilder();
        selectqueryBuilder.append("select t1.company_id, t1.time_id, t1.report_period");

        StringBuilder queryStringBuilder = new StringBuilder();

        StringBuilder whereQueryBuilder = new StringBuilder();
        whereQueryBuilder.append(" where").append(" ");

        int ratioQueryCounter = 0;

        for (String queryString : queryStrings) {
            if(shareKeywords.containsKey(queryString) && shareKeywords.get(queryString) != null) {

                Integer ratioId = shareKeywords.get(queryString);
                ratioQueryCounter++;

                if(ratioQueryCounter > 1)
                    queryStringBuilder.append(" join");

                selectqueryBuilder.append(", ratio").append(ratioQueryCounter);

                queryStringBuilder
                        .append(" (select company_id, time_id, report_period, ratio_value as ratio").append(ratioQueryCounter)
                        .append(" from RATIOVALUES where ratio_id = ").append(ratioId).append(") as t").append(ratioQueryCounter);

                if(ratioQueryCounter > 1){
                    queryStringBuilder
                            .append(" on t1.company_id = t").append(ratioQueryCounter).append(".company_id")
                            .append(" and t1.time_id = t").append(ratioQueryCounter).append(".time_id")
                            .append(" and t1.report_period = t").append(ratioQueryCounter).append(".report_period");
                }

                whereQueryBuilder
                        .append(" ratio").append(ratioQueryCounter);

            }else {
                whereQueryBuilder
                        .append(" ").append(queryString);
            }
        }

        return selectqueryBuilder.append(" from").append(queryStringBuilder.toString()).append(whereQueryBuilder.toString()).toString();
    }

    public static ArrayList<String> getKeys(String query, HashMap<String, Integer> shareKeywords) {
        String[] queryStrings = query.split(" ");

        ArrayList<String> list = new ArrayList<>();
        for (String queryString : queryStrings) {
            if (shareKeywords.containsKey(queryString) && shareKeywords.get(queryString) != null) {
                list.add(queryString);
            }
        }
        return list;
    }
}