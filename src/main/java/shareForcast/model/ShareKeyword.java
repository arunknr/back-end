package shareForcast.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SHAREKEYWORDS")
public class ShareKeyword {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "key_words")
    String keyword;

    @Column(name = "ratio_id")
    Integer ratioId;

    public ShareKeyword() {
    }

    public ShareKeyword(int id, String keyword, int ratioId) {
        this.id = id;
        this.keyword = keyword;
        this.ratioId = ratioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getRatioId() {
        return ratioId;
    }

    public void setRatioId(int ratioId) {
        this.ratioId = ratioId;
    }

    @Override
    public String toString() {
        return "ShareKeyword{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", ratioId=" + ratioId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShareKeyword that = (ShareKeyword) o;

        if (id != that.id) return false;
        if (ratioId != that.ratioId) return false;
        return !(keyword != null ? !keyword.equals(that.keyword) : that.keyword != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + ratioId;
        return result;
    }
}
