package shareForcast.model;


import javax.persistence.*;

@Entity
@Table(name = "COMPANYSHAREVALUE")
public class CompanyShareValue {

    @Id
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "company_name")
    String companyName;

    @Column(name = "eps")
    Double eps;

    @Column(name = "face_value")
    Double faceValue;

    @Column(name = "market_cap")
    Double marketCap;

    @Column(name = "price")
    Double price;

    public CompanyShareValue() {
    }

    public CompanyShareValue(int companyId, String companyName, Double eps, Double faceValue, Double marketCap, Double price) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.eps = eps;
        this.faceValue = faceValue;
        this.marketCap = marketCap;
        this.price = price;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getEps() {
        return eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }

    public Double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Double faceValue) {
        this.faceValue = faceValue;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyShareValue that = (CompanyShareValue) o;

        if (companyId != that.companyId) return false;
        if (!companyName.equals(that.companyName)) return false;
        if (!eps.equals(that.eps)) return false;
        if (!faceValue.equals(that.faceValue)) return false;
        if (!marketCap.equals(that.marketCap)) return false;
        return price.equals(that.price);
    }

    @Override
    public int hashCode() {
        int result = companyId;
        result = 31 * result + companyName.hashCode();
        result = 31 * result + eps.hashCode();
        result = 31 * result + faceValue.hashCode();
        result = 31 * result + marketCap.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}

