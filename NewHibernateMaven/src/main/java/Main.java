import models.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




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
        University university = new University();
        university.setId(3);
        university.setName("Lazy University");
        university.setShortName("LU");
        //main.save(university);
        //main.read(1, University.class);
        //main.update(university);
        //main.delete(0, University.class);
    }

    /* Method to SAVE in the database */
    public void save(Object obj) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();

    }

    /* Method to Read's by ID and Object type in the database */
    public void read(Integer id, Class<?> objectType) {
        Session session = factory.openSession();
        Object result = session.get(objectType, id);
        System.out.println(result.toString());
        session.close();
    }


    public void update(Object object) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(object);
        tx.commit();
        session.close();

    }

    public void delete(Integer id, Class<?> objectType) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Object object = session.get(objectType, id);
        session.delete(object);
        tx.commit();
        session.close();
    }

}
