package hibernate_test;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Ion", "Postolachi", "Development", 3);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println(employee);
        }
        finally {
            factory.close();
        }

    }
}