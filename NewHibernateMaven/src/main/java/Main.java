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
        /*University university = new University();
        university.setId(3);
        university.setName("Pula Belita");
        university.setShortName("PB");*/
        //main.save(university);
        //main.read(3, University.class);
        main.update(1, University.class);
        //main.delete(3, University.class);
    }

    /* Method to SAVE in the database */
    public Integer save(Object obj) {
        Session session = factory.openSession();
        Transaction tx;
        Integer objID;
        tx = session.beginTransaction();
        objID = (Integer) session.save(obj);
        tx.commit();
        session.close();
        return objID;
    }

    /* Method to Read's by ID and Object type in the database */
    public void read(Integer id, Class<?> objectType) {
        Session session = factory.openSession();
        Object result = session.get(objectType, id);
        System.out.println(result.toString());
        session.close();
    }


    public void update(Integer id, Class <?> obj) {
        Session session = factory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        Object object =session.get(obj, id);

        session.update(object);
        tx.commit();
        session.close();
    }

    public void delete(Integer id, Class<?> objectType) {
        Session session = factory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        Object object = session.get(objectType, id);
        session.delete(object);
        tx.commit();
        session.close();
    }

}
