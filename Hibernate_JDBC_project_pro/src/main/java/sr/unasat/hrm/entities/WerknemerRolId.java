package sr.unasat.hrm.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WerknemerRolId implements Serializable {

    private static final long serialVersionUID = 158549608633245531L;
    @Column(name = "werknemerId", nullable = false)
    private Integer werknemerId;

    @Column(name = "rolId", nullable = false)
    private Integer rolId;

    public Integer getWerknemerId() {
        return werknemerId;
    }

    public void setWerknemerId(Integer werknemerId) {
        this.werknemerId = werknemerId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WerknemerRolId entity = (WerknemerRolId) o;
        return Objects.equals(this.werknemerId, entity.werknemerId) &&
                Objects.equals(this.rolId, entity.rolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(werknemerId, rolId);
    }


}
