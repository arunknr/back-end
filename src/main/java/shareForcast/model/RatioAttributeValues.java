package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RATIOVALUES")
public class RatioAttributeValues {

    @Id
    RatioAttributeValuesPk id;

    @Column(name = "ratio_value")
    double ratioValue;

    public RatioAttributeValues() {
    }

    public RatioAttributeValues(RatioAttributeValuesPk id, double ratioValue) {
        this.id = id;
        this.ratioValue = ratioValue;
    }

    public RatioAttributeValuesPk getId() {
        return id;
    }

    public void setId(RatioAttributeValuesPk id) {
        this.id = id;
    }

    public double getRatioValue() {
        return ratioValue;
    }

    public void setRatioValue(double ratioValue) {
        this.ratioValue = ratioValue;
    }
}
