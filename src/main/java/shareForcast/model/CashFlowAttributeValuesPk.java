package shareForcast.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CashFlowAttributeValuesPk implements Serializable {

    @Column(name="company_id")
    int companyId;

    @Column(name="time_id")
    int timeId;

    @Column(name="report_period")
    int reportPeriod;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    CashFlowAttributes id;

    public CashFlowAttributeValuesPk() {
    }

    public CashFlowAttributeValuesPk(int companyId, int timeId, int reportPeriod, CashFlowAttributes id) {
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


    public CashFlowAttributes getId() {
        return this.id;
    }

    public void setId(CashFlowAttributes id) {
        this.id = id;
    }
}
