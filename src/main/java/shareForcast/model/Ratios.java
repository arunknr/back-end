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
    @Column(name = "id")
    int id;

    @NotNull
    @Column(name = "name")
    String name;

    @Column(name = "formula")
    String formula;

    public Ratios() {
    }

    public Ratios(int id, String name, String formula) {
        this.id = id;
        this.name = name;
        this.formula = formula;
    }

    public int getId() {
        return id;
    }

    public void setId(int ratioId) {
        this.id = ratioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String ratioName) {
        this.name = ratioName;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
