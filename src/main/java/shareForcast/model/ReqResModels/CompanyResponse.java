package shareForcast.model.reqResModels;

import shareForcast.model.CompanyInfo;

import java.util.ArrayList;
import java.util.List;

public class CompanyResponse {
    public List<CompanyInfo> getCompanyList() {
        return companyList;
    }

    public CompanyResponse(List<CompanyInfo> companyList) {
        this.companyList = companyList;
    }

    public void setCompanyList(List<CompanyInfo> companyList) {
        this.companyList = companyList;
    }

    List<CompanyInfo> companyList = new ArrayList<>();


    @Override
    public String toString() {
        return "CompanyResponse{" +
                "companyList=" + companyList +
                '}';
    }
}
