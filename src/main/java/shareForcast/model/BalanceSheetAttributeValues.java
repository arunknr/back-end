package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BALANCESHEETVALUES")
public class BalanceSheetAttributeValues {

    @Id
    BalanceSheetAttributeValuesPk id;

    @Column(name = "balancesheet_value")
    String value;

    public BalanceSheetAttributeValues() {
    }

    public BalanceSheetAttributeValues(BalanceSheetAttributeValuesPk id, String value) {
        this.id = id;
        this.value = value;
    }

    public BalanceSheetAttributeValuesPk getId() {
        return id;
    }

    public void setId(BalanceSheetAttributeValuesPk id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}