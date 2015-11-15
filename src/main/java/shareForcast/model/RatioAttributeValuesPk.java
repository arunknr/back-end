package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RatioAttributeValuesPk implements Serializable {


    @Column(name = "company_id")
    int companyId;

    @Column(name = "time_id")
    int timeId;

    @Column(name = "report_period")
    int reportPeriod;

    @Column(name = "ratio_id")
    int ratioId;

    public RatioAttributeValuesPk() {
    }

    public RatioAttributeValuesPk(int companyId, int timeId, int reportPeriod, int ratioId) {
        this.companyId = companyId;
        this.timeId = timeId;
        this.reportPeriod = reportPeriod;
        this.ratioId = ratioId;
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

    public int getRatioId() {
        return ratioId;
    }

    public void setRatioId(int ratioId) {
        this.ratioId = ratioId;
    }
}
