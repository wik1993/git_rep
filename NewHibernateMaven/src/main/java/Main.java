import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        main.listUniversities();
    /*    Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List<Professor> professors = (List<Professor>) session.createQuery(
                "from Professor ").list();
        for (Professor s : professors) {
            System.out.println("Student Details : " + s);
            System.out.println("Student University Details: "
                    + s.getUniversity());
        }
        tx.commit();
        session.close();*/
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
            University university = (University) univ;
            System.out.println("ID: " + university.getId());
            System.out.print(" University Name: " + university.getName());
            System.out.print(" University Short-Name: " + university.getShortName());
            System.out.println(" ");
        }
        tx.commit();
        session.close();
    }
}
