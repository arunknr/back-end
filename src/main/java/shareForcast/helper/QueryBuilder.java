package shareForcast.helper;

import java.util.ArrayList;
import java.util.HashMap;

public class QueryBuilder {

    public static String createQuery(String query, HashMap<String, Integer> shareKeywords) {
        query = query.toLowerCase().trim();
        String[] queryStrings = query.split(" ");
        String time_id = "5";
        String report_period = "201503";

        StringBuilder mainQueryBuilder = new StringBuilder();
        mainQueryBuilder.append("select r1.company_id, r3.company_name, r2.name, r1.ratio_value from RATIOVALUES as r1");
        mainQueryBuilder.append(" join (select id, name  from RATIOS) as r2");
        mainQueryBuilder.append(" on r1.ratio_id = r2.id");
        mainQueryBuilder.append(" join (select company_name, company_id  from COMPANYINFORMATION) as r3");
        mainQueryBuilder.append(" on r1.company_id = r3.company_id");
        mainQueryBuilder.append(" where r1.company_id in (");

        StringBuilder selectSubQueryBuilder = new StringBuilder();
        selectSubQueryBuilder.append("select distinct t1.company_id");

        StringBuilder subQueryStringBuilder = new StringBuilder();

        StringBuilder whereSubQueryBuilder = new StringBuilder();
        whereSubQueryBuilder.append(" where");

        StringBuilder whereMainQueryBuilder = new StringBuilder();
        whereMainQueryBuilder
                .append(" and time_id = ").append(time_id)
                .append(" and report_period = ").append(report_period);

        int ratioQueryCounter = 0;

        for (String queryString : queryStrings) {
            if(shareKeywords.containsKey(queryString) && shareKeywords.get(queryString) != null) {

                Integer ratioId = shareKeywords.get(queryString);
                ratioQueryCounter++;

                if(ratioQueryCounter > 1)
                    subQueryStringBuilder.append(" join");

                //selectSubQueryBuilder.append(", ratio").append(ratioQueryCounter);

                subQueryStringBuilder
                        .append(" (select company_id, ratio_value as ratio").append(ratioQueryCounter)
                        .append(" from RATIOVALUES where ratio_id = ").append(ratioId)
                        .append(" and time_id = ").append(time_id)
                        .append(" and report_period = ").append(report_period)
                        .append(") as t").append(ratioQueryCounter);

                if(ratioQueryCounter > 1){
                    subQueryStringBuilder
                            .append(" on t1.company_id = t").append(ratioQueryCounter).append(".company_id");
                }

                whereSubQueryBuilder
                        .append(" ratio").append(ratioQueryCounter);

            }else {
                whereSubQueryBuilder
                        .append(" ").append(queryString);
            }
        }

        return mainQueryBuilder
                .append(selectSubQueryBuilder.toString())
                .append(" from")
                .append(subQueryStringBuilder.toString())
                .append(whereSubQueryBuilder.toString())
                .append(")")
                .append(whereMainQueryBuilder.toString()).toString();
    }

    public static ArrayList<String> getKeys(String query, HashMap<String, Integer> shareKeywords) {
        query = query.toLowerCase().trim();
        String[] queryStrings = query.split(" ");

        ArrayList<String> list = new ArrayList<>();
        list.add("CompanyId");
        list.add("CompanyName");
        list.add("RatioId");
        list.add("RatioValue");
        /*for (String queryString : queryStrings) {
            if (shareKeywords.containsKey(queryString) && shareKeywords.get(queryString) != null) {
                list.add(queryString);
            }
        }*/
        return list;
    }
}