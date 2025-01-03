package sr.unasat.hrm.DTO;

import sr.unasat.hrm.entities.Afdeling;
import sr.unasat.hrm.entities.Functie;

public class WerknemerDTO {
    private Integer id;

    private String voornaam;

    private String achternaam;

    private String extensie;

    private String telefoon;

    private Afdeling afdeling;

    private Functie functie;

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

    public String getExtensie() {
        return extensie;
    }

    public void setExtensie(String extensie) {
        this.extensie = extensie;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }

    public Functie getFunctie() {
        return functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }

    @Override
    public String toString() {
        return "WerknemerDTO{" +
                "id=" + id +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", extensie='" + extensie + '\'' +
                ", telefoon='" + telefoon + '\'' +
                ", afdeling=" + afdeling +
                ", functie=" + functie +
                '}';
    }
}
