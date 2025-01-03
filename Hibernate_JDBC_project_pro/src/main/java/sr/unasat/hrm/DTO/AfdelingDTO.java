package sr.unasat.hrm.DTO;

public class AfdelingDTO {
    private Integer id;
    private String naam;

    public AfdelingDTO() {
    }

    public AfdelingDTO(Integer id, String naam) {
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
        return "AfdelingDTO{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
