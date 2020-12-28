package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

       try {
           session = factory.getCurrentSession();
//            Employee employee = new Employee("Mihai","Postolachi","OP",5);
//            Detail detail = new Detail("Chisinau","123456","pmmop@mail.ru");

//            Employee employee = new Employee("Natalia","Constantinov","Scoala",6);
//            Detail detail = new Detail("Dorotcaia","126543","natalia@mail.ru");
//
//
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done");


            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);
           System.out.println(employee.getEmpDetail());

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
           session.close();
            factory.close();
        }

    }
}
