package shareForcast.services;

import org.springframework.stereotype.Component;
import shareForcast.DAO.KeywordDAO;
import shareForcast.model.ShareKeyword;
import java.util.List;

@Component
public class KeywordService {
    public List<ShareKeyword> fetch() {
        return new KeywordDAO().getAll();
    }
}
