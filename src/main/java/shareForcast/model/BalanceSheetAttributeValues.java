package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.util.DoubleSummaryStatistics;

@Entity
@Table(name = "BALANCESHEETVALUES")
public class BalanceSheetAttributeValues {

    @Id
    BalanceSheetAttributeValuesPk id;

    @Column(name = "balancesheet_value")
    Double value;

    public BalanceSheetAttributeValues() {
    }

    public BalanceSheetAttributeValues(BalanceSheetAttributeValuesPk id, Double value) {
        this.id = id;
        this.value = value;
    }

    public BalanceSheetAttributeValuesPk getId() {
        return id;
    }

    public void setId(BalanceSheetAttributeValuesPk id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}