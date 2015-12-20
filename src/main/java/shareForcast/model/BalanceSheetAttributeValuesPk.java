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
    @JoinColumn(name = "balancesheet_id")
    BalanceSheetAttributes balancesheet_id;

    public BalanceSheetAttributeValuesPk() {
    }

    public BalanceSheetAttributeValuesPk(int companyId, int timeId, int reportPeriod, BalanceSheetAttributes balancesheet_id) {
        this.companyId = companyId;
        this.timeId = timeId;
        this.reportPeriod = reportPeriod;
        this.balancesheet_id = balancesheet_id;
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


    public BalanceSheetAttributes getBalancesheet_id() {
        return this.balancesheet_id;
    }

    public void setBalancesheet_id(BalanceSheetAttributes balancesheet_id) {
        this.balancesheet_id = balancesheet_id;
    }
}
