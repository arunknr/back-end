package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PERIOD")
public class Period {

    @Id
    @NotNull
    @Column(name = "id")
    int id;

    @NotNull
    @Column(name = "name")
    String name;

    public Period() {
    }

    public Period(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
