package hibernate_CRUD;

import hibernate_CRUD.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2_CreateAndGetObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee emp = new Employee("Oleg", "Semenov", "HR", 600);

            session.beginTransaction(); // открытие транзакции
            session.save(emp);
//            session.getTransaction().commit(); //закрытие транзакции - коммит

            int myId = emp.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);

            session.getTransaction().commit();

            System.out.println(employee);
            System.out.println("Done!");
        } finally {
            factory.close();
            session.close();
        }
    }
}
