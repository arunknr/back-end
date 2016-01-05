package shareForcast.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COMPANYINFORMATION")
public class CompanyInfo {

    @Id
    @Column(name = "company_id")
    int companyId;

    @NotNull
    @Column(name = "accord_id")
    int accordId;

    @Column(name = "bse_id")
    int bseId;

    @Column(name = "nse_id")
    String nseId;

    @NotNull
    @Column(name = "company_name")
    String companyName;

    @NotNull
    @Column(name = "bse_listed", columnDefinition = "BIT")
    boolean bseListed;

    @NotNull
    @Column(name = "nse_listed", columnDefinition = "BIT")
    boolean nseListed;

    @Column(name = "industry")
    String industry;

    @Column(name = "market_cap")
    String marketCap;

    public CompanyInfo() {
    }

    public CompanyInfo(int companyId, int accordId, int bseId, String nseId, String companyName, boolean bseListed, boolean nseListed, String industry, String marketCap) {
        this.companyId = companyId;
        this.accordId = accordId;
        this.bseId = bseId;
        this.nseId = nseId;
        this.companyName = companyName;
        this.bseListed = bseListed;
        this.nseListed = nseListed;
        this.industry = industry;
        this.marketCap = marketCap;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getAccordId() {
        return accordId;
    }

    public void setAccordId(int accordId) {
        this.accordId = accordId;
    }

    public int getBseId() {
        return bseId;
    }

    public void setBseId(int bseId) {
        this.bseId = bseId;
    }

    public String getNseId() {
        return nseId;
    }

    public void setNseId(String nseId) {
        this.nseId = nseId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isBseListed() {
        return bseListed;
    }

    public void setBseListed(boolean bseListed) {
        this.bseListed = bseListed;
    }

    public boolean isNseListed() {
        return nseListed;
    }

    public void setNseListed(boolean nseListed) {
        this.nseListed = nseListed;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "companyId=" + companyId +
                ", accordId=" + accordId +
                ", bseId=" + bseId +
                ", nseId='" + nseId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", bseListed=" + bseListed +
                ", nseListed=" + nseListed +
                ", industry='" + industry + '\'' +
                ", marketCap='" + marketCap + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyInfo that = (CompanyInfo) o;

        if (companyId != that.companyId) return false;
        if (accordId != that.accordId) return false;
        if (bseId != that.bseId) return false;
        if (bseListed != that.bseListed) return false;
        if (nseListed != that.nseListed) return false;
        if (nseId != null ? !nseId.equals(that.nseId) : that.nseId != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (industry != null ? !industry.equals(that.industry) : that.industry != null) return false;
        return !(marketCap != null ? !marketCap.equals(that.marketCap) : that.marketCap != null);

    }

    @Override
    public int hashCode() {
        int result = companyId;
        result = 31 * result + accordId;
        result = 31 * result + bseId;
        result = 31 * result + (nseId != null ? nseId.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (bseListed ? 1 : 0);
        result = 31 * result + (nseListed ? 1 : 0);
        result = 31 * result + (industry != null ? industry.hashCode() : 0);
        result = 31 * result + (marketCap != null ? marketCap.hashCode() : 0);
        return result;
    }
}
