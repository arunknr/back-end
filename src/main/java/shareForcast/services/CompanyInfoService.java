package shareForcast.services;

import org.springframework.stereotype.Component;
import shareForcast.DAO.CompanyInfoDAO;
import shareForcast.model.CompanyInfo;

@Component
public class CompanyInfoService extends CompanyInfo {
    public CompanyInfoService() {
    }

    public CompanyInfo get(int accordId, int shianId) {
        return new CompanyInfoDAO().get(accordId, shianId);
    }
}
