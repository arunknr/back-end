package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.util.DoubleSummaryStatistics;

@Entity
@Table(name = "CASHFLOWVALUES")
public class CashFlowAttributeValues {

    @Id
    CashFlowAttributeValuesPk id;

    @Column(name = "cashflow_value")
    Double value;

    public CashFlowAttributeValues() {
    }

    public CashFlowAttributeValues(CashFlowAttributeValuesPk id, Double value) {
        this.id = id;
        this.value = value;
    }

    public CashFlowAttributeValuesPk getId() {
        return id;
    }

    public void setId(CashFlowAttributeValuesPk id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}