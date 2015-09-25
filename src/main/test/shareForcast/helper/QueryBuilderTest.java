package shareForcast.helper;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QueryBuilderTest {

    @Test
    public void testingTransformationIshappeningRight(){
        QueryBuilder queryBuilder = new QueryBuilder();
        String query = queryBuilder.createQuery("EPS > FACE VALUE");

        assertTrue(query.equals("FROM CompanyShareValue WHERE eps > faceValue"));
    }

    @Test
    public void testingTransformationWhenQueryHasExtraSpaces(){
        QueryBuilder queryBuilder = new QueryBuilder();
        String query = queryBuilder.createQuery(" EPS > FACE VALUE");

        assertTrue(query.equals("FROM CompanyShareValue WHERE eps > faceValue"));
    }

    @Test
    public void testingTransformationWhenQueryIsInUppercase(){
        QueryBuilder queryBuilder = new QueryBuilder();
        String query = queryBuilder.createQuery("EPS > FACE VALUE");

        assertTrue(query.equals("FROM CompanyShareValue WHERE eps > faceValue"));
    }
}