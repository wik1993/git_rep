import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import java.util.List;


public class Main {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Main main = new Main();
        //main.listUniversities();
        //main.listProfessors();
    }
    /* Method to ADD an university in the database */
    public Integer addUniversity(int id, String name, String shortName) {
        Session session = factory.openSession();
        Transaction tx;
        Integer universityID;
        tx = session.beginTransaction();
        University university = new University();
        university.setId(id);
        university.setName(name);
        university.setShortName(shortName);
        universityID = (Integer) session.save(university);
        tx.commit();
        session.close();
        return universityID;
    }

    public void listUniversities() {
        Session session = factory.openSession();
        Transaction tx;
        tx = session.beginTransaction();
        List universities = session.createQuery("FROM University").list();
        for (Object univ : universities) {
            System.out.println(univ.toString());
        }
        tx.commit();
        session.close();
    }

    public void listProfessors() {
        Session session = factory.openSession();
        Transaction tx;
        tx = session.beginTransaction();
        List professors = session.createQuery("FROM Professor").list();
        for (Object prof : professors) {
            Professor professor = (Professor) prof;
            System.out.println(professor.toString());
        }
        tx.commit();
        session.close();
    }
}
