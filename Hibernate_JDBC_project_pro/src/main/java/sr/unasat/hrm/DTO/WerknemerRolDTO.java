package sr.unasat.hrm.DTO;

public class WerknemerRolDTO {
    private Integer id;
    private String naam;

    public WerknemerRolDTO() {}

    public WerknemerRolDTO(Integer id, String naam) {
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

    @Override
    public String toString() {
        return "RolDTO{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
