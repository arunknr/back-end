package shareForcast.model;

public class CompanyDetails {
    private String companyName;

    public CompanyDetails() {
    }

    public CompanyDetails(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
