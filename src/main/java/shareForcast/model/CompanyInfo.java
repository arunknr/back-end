package shareForcast.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COMPANYINFORMATION")
public class CompanyInfo {

    @Id
    CompanyInfoPk id;

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

    @Column(name = "group_name")
    String groupName;

    @Column(name = "market_cap")
    String marketCap;

    public CompanyInfo() {
    }

    public CompanyInfo(CompanyInfoPk id, int bseId, String nseId, String companyName, boolean bseListed, boolean nseListed, String groupName, String marketCap) {
        this.id = id;
        this.bseId = bseId;
        this.nseId = nseId;
        this.companyName = companyName;
        this.bseListed = bseListed;
        this.nseListed = nseListed;
        this.groupName = groupName;
        this.marketCap = marketCap;
    }

    public CompanyInfoPk getId() {
        return id;
    }

    public void setId(CompanyInfoPk id) {
        this.id = id;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }
}
