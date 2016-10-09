
package lv.javaguru.java2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
public class Category implements BaseEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "father_id")
    private long fatherId;

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if ((object == null) || !(object instanceof Category)) {
            return false;
        }
        Category that = (Category) object;
        return new EqualsBuilder()
                .append(id, that.getId())
                .append(name, that.getName())
                .append(fatherId, that.getFatherId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(fatherId)
                .toHashCode();
    }
}