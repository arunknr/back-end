package shareForcast.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BALANCESHEET")
public class BalanceSheetAttributes {

    @Id
    @NotNull
    @Column(name = "balancesheet_id")
    int id;

    @NotNull
    @Column(name = "level_id")
    int levelId;

    @Column(name = "value_required", columnDefinition = "BIT")
    boolean valueRequired;

    @Column(name = "bold_required", columnDefinition = "BIT")
    boolean boldRequired;

    @Column(name = "balancesheet_name")
    String name;

    public BalanceSheetAttributes() {
    }

    public BalanceSheetAttributes(int id, int levelId, boolean valueRequired, boolean boldRequired, String name) {
        this.id = id;
        this.levelId = levelId;
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

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
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
