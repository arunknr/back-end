package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.CompanyInfoDAO;
import shareForcast.model.CompanyInfo;

@Component
public class CompanyInfoService {
    private CompanyInfoDAO companyInfoDAO;

    @Autowired
    public CompanyInfoService(CompanyInfoDAO companyInfoDAO) {
        this.companyInfoDAO = companyInfoDAO;
    }

    public CompanyInfo get(int companyId) {
        return companyInfoDAO.get(companyId);
    }
}
