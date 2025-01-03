package sr.unasat.hrm.DTO;

public class FunctieDTO {
    private Integer id;
    private String naam;

    public FunctieDTO() {}

    public FunctieDTO(Integer id, String naam) {
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
        return "FunctieDTO{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
