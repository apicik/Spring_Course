package hibernate_CRUD;

import hibernate_CRUD.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3_GetObjects {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction(); // открытие транзакции

            List<Employee> employeeList = session.createQuery("from Worker " +
                    "where name = 'Aleksandr'" +
                    "AND salary>500")
                    .getResultList();

            employeeList.forEach(System.out::println);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
            session.close();
        }
    }
}
