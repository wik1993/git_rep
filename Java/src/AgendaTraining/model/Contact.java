package AgendaTraining.model;

public class Contact {
    private Integer id;
    private String nume;
    private String prenume;
    private String nrTelefon;
    private Boolean isFavorite;

    public Contact() {
    }

    public Contact(Integer id, String nume, String prenume, String nrTelefon, Boolean isFavorite) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
        this.isFavorite = isFavorite;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", nrTelefon='" + nrTelefon + '\'' +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
