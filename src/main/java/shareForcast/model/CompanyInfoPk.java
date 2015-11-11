package shareForcast.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompanyInfoPk implements Serializable {

    @Column(name = "accord_id")
    int accordId;

    @Column(name = "shian_id")
    int shianId;

    public CompanyInfoPk() {
    }

    public CompanyInfoPk(int accordId, int shianId) {
        this.accordId = accordId;
        this.shianId = shianId;
    }

    public int getAccordId() {
        return accordId;
    }

    public void setAccordId(int accordId) {
        this.accordId = accordId;
    }

    public int getShianId() {
        return shianId;
    }

    public void setShianId(int shianId) {
        this.shianId = shianId;
    }
}
