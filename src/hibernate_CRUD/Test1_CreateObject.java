package hibernate_CRUD;

import hibernate_CRUD.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_CreateObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee emp = new Employee("Aleksandr", "ForDelete", "IT", 800);

            session.beginTransaction(); // открытие транзакции
            session.save(emp);
            session.getTransaction().commit(); //закрытие транзакции - коммит

            System.out.println("Done!");
            System.out.println(emp);
        } finally {
            factory.close();
            session.close();
        }
    }
}
