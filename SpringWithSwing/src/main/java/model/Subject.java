package model;



import java.util.List;



public class Subject {

    private int id;

    private String name;

    private int numberHour;


    private List<Professor> professors;


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

    public void setNumberHour(int numberHour) {
        this.numberHour = numberHour;
    }

    @Override
    public String toString() {
        return "models.Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberHour=" + numberHour +
                '}';
    }
}
