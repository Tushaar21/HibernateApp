package sr.unasat.hrm.entities;


import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "naam")
    private String naam;

    @ManyToMany
    @JoinTable(name = "werknemer_rol",
            joinColumns = @JoinColumn(name = "rolId"),
            inverseJoinColumns = @JoinColumn(name = "werknemerId"))
    private Set<Werknemer> werknemerRolen = new LinkedHashSet<>();

    public Rol() {
    }

    public Rol(Integer id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Set<Werknemer> getWerknemerRolen() {
        return werknemerRolen;
    }

    public void setWerknemerRolen(Set<Werknemer> werknemerRolen) {
        this.werknemerRolen = werknemerRolen;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
