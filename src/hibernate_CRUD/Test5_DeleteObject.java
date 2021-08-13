package hibernate_CRUD;

import hibernate_CRUD.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5_DeleteObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction(); // открытие транзакции

            // Способ удаления записи используя ID и получение объекта
//            Employee employeeDelete = session.get(Employee.class, 10);
//            session.delete(employeeDelete);

            // Удаление используя запрос HQL - hibernate query language
            System.out.println("Before Delete");
            session.createQuery("delete Worker where surname = 'ForDelete'").executeUpdate();

            // Сохранение изменений в БД
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
            session.close();
        }
    }
}
