package shareForcast.services;

import org.springframework.stereotype.Component;
import shareForcast.DAO.QueryDAO;
import shareForcast.helper.QueryBuilder;
import shareForcast.model.CompanyShareValue;
import java.util.List;

@Component
public class QueryService {
    public List<CompanyShareValue> getResultForQuery(String query) {
        QueryDAO queryDAO = new QueryDAO();
        QueryBuilder queryBuilder = new QueryBuilder();
        String generatedQuery = queryBuilder.createQuery(query);
        return queryDAO.get(generatedQuery);
    }
}