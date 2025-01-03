package sr.unasat.hrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "werknemer_rol")
public class WerknemerRol {

    @EmbeddedId
    private WerknemerRolId id;

    @MapsId("werknemerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "werknemerId", nullable = false)
    private Werknemer werknemerid;

    @MapsId("rolId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rolId", nullable = false)
    private Rol rolid;


    public WerknemerRolId getId() {
        return id;
    }

    public void setId(WerknemerRolId id) {
        this.id = id;
    }

    public Werknemer getWerknemerid() {
        return werknemerid;
    }

    public void setWerknemerid(Werknemer werknemerid) {
        this.werknemerid = werknemerid;
    }

    public Rol getRolid() {
        return rolid;
    }

    public void setRolid(Rol rollid) {
        this.rolid = rollid;
    }
}
