package shareForcast.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProfitLossAttributeValuesPk implements Serializable {

    @Column(name="company_id")
    int companyId;

    @Column(name="time_id")
    int timeId;

    @Column(name="report_period")
    int reportPeriod;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    ProfitLossAttributes id;

    public ProfitLossAttributeValuesPk() {
    }

    public ProfitLossAttributeValuesPk(int companyId, int timeId, int reportPeriod, ProfitLossAttributes id) {
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


    public ProfitLossAttributes getId() {
        return this.id;
    }

    public void setId(ProfitLossAttributes id) {
        this.id = id;
    }
}
