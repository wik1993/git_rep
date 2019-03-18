package models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "professors")
public class Professor {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "prof_subject",
            joinColumns = { @JoinColumn(name = "professor_id") },
            inverseJoinColumns = { @JoinColumn(name = "subject_id") }
    )
    private List<Subject> subjects;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;


    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "models.Professor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
