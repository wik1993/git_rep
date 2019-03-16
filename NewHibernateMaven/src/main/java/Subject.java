import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_hour")
    private int numberHour;

    @ManyToMany(mappedBy = "subjects")
    private List<Professor> professors;

    public Subject() {}

    public Subject(int id, String name, int numberHour) {
        this.id = id;
        this.name = name;
        this.numberHour = numberHour;
    }


    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberHour() {
        return numberHour;
    }

    public void setNumberHour(int numbeHour) {
        this.numberHour = numberHour;
    }

   @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberHour=" + numberHour +
                '}';
    }
}
