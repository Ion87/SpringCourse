package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

//            Employee employee1 = new Employee("Violeta","Mitu","PSIH",9);
//
//            Detail detail = new Detail("Paris","098765","Leta@mail.ru");
//
//            employee1.setEmpDetail(detail);
//            detail.setEmployee(employee1);
//            session.beginTransaction();
//
//            Detail detail = session.get(Detail.class,3);
//            System.out.println(detail);

            session.beginTransaction();

            Detail detail = session.get(Detail.class,2);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
