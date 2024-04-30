
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.List;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        /* 
         * Skapa tre studenter och en tutor (eller tre böcker och en author) och persistera dem i databasen.
         */
        Student student1 = new Student("James Bond");
        Student student2 = new Student("Pharrel William");
        Student student3 = new Student("Albert Einstein");
        Tutor tutor1 = new Tutor("A1234","Nahid", 60000);

        tutor1.addStudent(student1);
        tutor1.addStudent(student2);
        tutor1.addStudent(student3);

        
        /* 
         * Hämta nu alla studenter för en särskild handledare från databasen och skriv ut dem
         */
        List<Student> students = tutor1.getTeachingGroup();
        for (Student student : students) {
            System.out.println(student);
        }

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(tutor1);


        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
