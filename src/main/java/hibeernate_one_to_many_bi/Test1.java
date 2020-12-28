package hibeernate_one_to_many_bi;

import hibeernate_one_to_many_bi.entity.Department;
import hibeernate_one_to_many_bi.entity.Employee2;
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

//            Department department = new Department("IT", 300, 1200);
//
//            Employee2 employee2 = new Employee2("Ionel","Postolachi",650);
//            Employee2 employee21 = new Employee2("Vano","Getman",850);
//           Employee2 employee22 = new Employee2("Adrian","Antonov",200);
//
//           department.addEmployeeToDepartment(employee2);
//           department.addEmployeeToDepartment(employee21);
//           department.addEmployeeToDepartment(employee22);
//
//           session.beginTransaction();
//
//           session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done");

//           session = factory.getCurrentSession();
//
//           session.beginTransaction();
//
//           Employee2 employee2 = session.get(Employee2.class,4);
//           System.out.println(employee2);
//           session.delete(employee2);
//
//           session.getTransaction().commit();
//           System.out.println("Done");


           session = factory.getCurrentSession();

           session.beginTransaction();
           System.out.println("Get department");
           Department department = session.get(Department.class,4);
           System.out.println("Show department");
           System.out.println(department);

           session.getTransaction().commit();
           System.out.println("Done");

           System.out.println("Show employees of the deparment");
           System.out.println(department.getEmps());
        }
        finally {
           session.close();
            factory.close();
        }

    }
}
