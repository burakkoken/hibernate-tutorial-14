import Models.Employee;
import Models.Job;
import jdk.nashorn.internal.scripts.JO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by Burak Köken on 28.5.2017.
 */
public class HibernateTest {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("Burak Köken");
        employee1.setSalary(4500);
        employee1.setBirthDate(new Date());

        Job job1 = new Job();
        job1.setName("Java Software Developer");
        employee1.setJob(job1);

        Employee employee2 = new Employee();
        employee2.setName("Berk Semerci");
        employee2.setSalary(5000);
        employee2.setBirthDate(new Date());

        Job job2 = new Job();
        job2.setName("Android Software Developer");
        employee2.setJob(job2);

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(employee1);
        session.save(job1);
        session.save(employee2);
        session.save(job2);
        session.getTransaction().commit();

        session.close();

    }

}
