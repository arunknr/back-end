package shareForcast.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CASHFLOW")
public class CashFlowAttributes {

    @Id
    @NotNull
    @Column(name = "id")
    int id;

    @NotNull
    @Column(name = "level_indicator")
    int levelIndicator;

    @Column(name = "value_required", columnDefinition = "BIT")
    boolean valueRequired;

    @Column(name = "bold_required", columnDefinition = "BIT")
    boolean boldRequired;

    @Column(name = "name")
    String name;

    public CashFlowAttributes() {
    }

    public CashFlowAttributes(int id, int levelIndicator, boolean valueRequired, boolean boldRequired, String name) {
        this.id = id;
        this.levelIndicator = levelIndicator;
        this.valueRequired = valueRequired;
        this.boldRequired = boldRequired;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevelIndicator() {
        return levelIndicator;
    }

    public void setLevelIndicator(int levelId) {
        this.levelIndicator = levelId;
    }

    public boolean isValueRequired() {
        return valueRequired;
    }

    public void setValueRequired(boolean valueRequired) {
        this.valueRequired = valueRequired;
    }

    public boolean isBoldRequired() {
        return boldRequired;
    }

    public void setBoldRequired(boolean boldRequired) {
        this.boldRequired = boldRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
