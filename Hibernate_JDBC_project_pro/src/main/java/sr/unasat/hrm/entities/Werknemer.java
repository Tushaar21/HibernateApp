package sr.unasat.hrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "werknemer")
public class Werknemer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String voornaam;
    private String achternaam;
    private String telefoon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "functie", nullable = false)
    private Functie functie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "afdeling", nullable = false)
    private Afdeling afdeling;

    public Werknemer() {
    }

    public Werknemer(Integer id, String voornaam, String achternaam, String telefoon, Functie functie, Afdeling afdeling) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.telefoon = telefoon;
        this.functie = functie;
        this.afdeling = afdeling;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public Functie getFunctie() {
        return functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }

    @Override
    public String toString() {
        return "Werknemer{" +
                "id=" + id +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", telefoon='" + telefoon + '\'' +
                ", functie=" + functie +
                ", afdeling=" + afdeling +
                '}';
    }
}
