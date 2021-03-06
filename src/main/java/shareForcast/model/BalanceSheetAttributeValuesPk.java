package shareForcast.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BalanceSheetAttributeValuesPk implements Serializable {

    @Column(name="company_id")
    int companyId;

    @Column(name="time_id")
    int timeId;

    @Column(name="report_period")
    int reportPeriod;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    BalanceSheetAttributes id;

    public BalanceSheetAttributeValuesPk() {
    }

    public BalanceSheetAttributeValuesPk(int companyId, int timeId, int reportPeriod, BalanceSheetAttributes id) {
        this.companyId = companyId;
        this.timeId = timeId;
        this.reportPeriod = reportPeriod;
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(int reportPeriod) {
        this.reportPeriod = reportPeriod;
    }


    public BalanceSheetAttributes getId() {
        return this.id;
    }

    public void setId(BalanceSheetAttributes id) {
        this.id = id;
    }
}
