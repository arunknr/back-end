package shareForcast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shareForcast.DAO.CompanyDAO;
import shareForcast.model.CompanyInfo;

import java.util.List;

@Component
public class CompanyService {

    private CompanyDAO companyDAO;

    @Autowired
    public CompanyService(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public List<CompanyInfo> fetch() {
        return companyDAO.getAll();
    }
}
