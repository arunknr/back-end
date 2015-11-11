package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RATIOS")
public class Ratios {

    @Id
    @NotNull
    @Column(name = "ratio_id")
    int ratioId;

    @NotNull
    @Column(name = "ratio_name")
    String ratioName;

    @Column(name = "query_value")
    String queryValue;

    public Ratios() {
    }

    public Ratios(int ratioId, String ratioName, String queryValue) {
        this.ratioId = ratioId;
        this.ratioName = ratioName;
        this.queryValue = queryValue;
    }

    public int getRatioId() {
        return ratioId;
    }

    public void setRatioId(int ratioId) {
        this.ratioId = ratioId;
    }

    public String getRatioName() {
        return ratioName;
    }

    public void setRatioName(String ratioName) {
        this.ratioName = ratioName;
    }

    public String getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }
}
