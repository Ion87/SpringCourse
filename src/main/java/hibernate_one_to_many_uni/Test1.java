package hibernate_one_to_many_uni;


import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee2.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Department department = session.get(Department.class, 2);

            session.delete(department);


//            System.out.println(department);
//            System.out.println(department.getEmps());

//            Department department = new Department("HR", 400, 1000);
//
//            Employee2 employee2 = new Employee2("Artiom","Taralunga",690);
//            Employee2 employee21 = new Employee2("Sergiu","Cercel",800);
//
//           department.addEmployeeToDepartment(employee2);
//           department.addEmployeeToDepartment(employee21);
//
//           session.beginTransaction();
//
//           session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee2 employee2 = session.get(Employee2.class,4);
//            System.out.println(employee2);
//            session.delete(employee2);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
