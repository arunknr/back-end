package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BalanceSheetAttributeValuesPk implements Serializable {

    @Column(name="company_id")
    int companyId;

    @Column(name="time_id")
    int timeId;

    @Column(name="report_period")
    int reportPeriod;

    @Column(name="balancesheet_id")
    int balanceSheetAttrId;

    public BalanceSheetAttributeValuesPk() {
    }

    public BalanceSheetAttributeValuesPk(int companyId, int timeId, int reportPeriod, int balanceSheetAttrId) {
        this.companyId = companyId;
        this.timeId = timeId;
        this.reportPeriod = reportPeriod;
        this.balanceSheetAttrId = balanceSheetAttrId;
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

    public int getBalanceSheetAttrId() {
        return balanceSheetAttrId;
    }

    public void setBalanceSheetAttrId(int balanceSheetAttrId) {
        this.balanceSheetAttrId = balanceSheetAttrId;
    }
}
