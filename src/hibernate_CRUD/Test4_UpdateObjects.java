package hibernate_CRUD;

import hibernate_CRUD.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4_UpdateObjects {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction(); // открытие транзакции

            // Способ обновления значений нескольких объектов
//            session.createQuery("update Employee " +
//                    "set salary=1000" +
//                    "where name = 'Aleksandr'")
//                    .executeUpdate();

            // Получение записи(объекта) из БД
            int updateId = 4;
            Employee employee = session.get(Employee.class, updateId);
            employee.setSurname("Gurov");
            employee.setDepartment("ADM");
            employee.setSalary(650);

            // Сохранение изменений в БД
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
            session.close();
        }
    }
}
