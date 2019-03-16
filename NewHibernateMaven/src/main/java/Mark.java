import javax.persistence.*;

@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private int value;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Mark() {}

    public Mark(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", value=" + value +
/*                ", subject=" + subject.getName() +
                ", student=" + student.getFirstName() + " " + student.getLastName() +*/
                '}';
    }
}
