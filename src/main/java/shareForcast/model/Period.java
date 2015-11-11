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
    @Column(name = "time_id")
    int time_id;

    @NotNull
    @Column(name = "time_value")
    String timeValue;

    public Period() {
    }

    public Period(int time_id, String timeValue) {
        this.time_id = time_id;
        this.timeValue = timeValue;
    }

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }
}
