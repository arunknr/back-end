package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BalanceSheetAttributeValuesPk implements Serializable {

    @Column(name="shian_id")
    int shianId;

    @Column(name="time_id")
    int timeId;

    @Column(name="report_period")
    int reportPeriod;

    @Column(name="balancesheet_id")
    int balanceSheetAttrId;

    public BalanceSheetAttributeValuesPk() {
    }

    public BalanceSheetAttributeValuesPk(int shianId, int timeId, int reportPeriod, int balanceSheetAttrId) {
        this.shianId = shianId;
        this.timeId = timeId;
        this.reportPeriod = reportPeriod;
        this.balanceSheetAttrId = balanceSheetAttrId;
    }

    public int getShianId() {
        return shianId;
    }

    public void setShianId(int shianId) {
        this.shianId = shianId;
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
