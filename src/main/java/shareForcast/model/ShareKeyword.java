package shareForcast.model;

import javax.persistence.*;

@Entity
@Table(name = "SHAREKEYWORDS")
public class ShareKeyword {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "key_words")
    String keyword;

    public ShareKeyword() {
    }

    public ShareKeyword(int id, String keyword) {
        this.id = id;
        this.keyword = keyword;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShareKeyword that = (ShareKeyword) o;

        return !(keyword != null ? !keyword.equals(that.keyword) : that.keyword != null);

    }

    @Override
    public int hashCode() {
        return keyword != null ? keyword.hashCode() : 0;
    }
}
