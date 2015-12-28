package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.util.DoubleSummaryStatistics;

@Entity
@Table(name = "PROFITLOSSVALUES")
public class ProfitLossAttributeValues {

    @Id
    ProfitLossAttributeValuesPk id;

    @Column(name = "profitloss_value")
    Double value;

    public ProfitLossAttributeValues() {
    }

    public ProfitLossAttributeValues(ProfitLossAttributeValuesPk id, Double value) {
        this.id = id;
        this.value = value;
    }

    public ProfitLossAttributeValuesPk getId() {
        return id;
    }

    public void setId(ProfitLossAttributeValuesPk id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}