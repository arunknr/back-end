package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.KeywordDAO;
import shareForcast.model.ShareKeyword;
import java.util.List;

@Component
public class KeywordService {

    private KeywordDAO keywordDAO;

    @Autowired
    public KeywordService(KeywordDAO keywordDAO) {
        this.keywordDAO = keywordDAO;
    }

    public List<ShareKeyword> fetch() {
        return keywordDAO.getAll();
    }
}
