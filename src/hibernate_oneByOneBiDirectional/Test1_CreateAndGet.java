package hibernate_oneByOneBiDirectional;

import hibernate_oneByOneBiDirectional.entity.Detail;
import hibernate_oneByOneBiDirectional.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_CreateAndGet {
    /**
     * В данном пакете происходит используется двухсторонняя связь между Работником и Деталями о нем,
     * в Деталях связывание происходит через маппинг поля empDetail таблицы Работников. Данное связывание
     * позволяет добиться каскадного влияния(удаление, связывание - создание) на таблицу работников.
     * Можно создать детали и работника и сохранить работника в детали, произведя коммит сохранение
     * произойдет в обе таблицы, однако требуется сохранение в работника тоже
     * @param args
     */
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession(); // получить сессию
            session.beginTransaction(); // открытие транзакции

            Employee employee = new Employee("Vasya" , "Petrov", "Sales", 450);
            Detail detail = new Detail("Samara", "234", "vasyan@ya.ru");//

            // сеттеры используется для двунаправленной связи записей таблицы
            detail.setEmployee(employee);
            employee.setEmpDetail(detail);

            session.save(employee);

            session.getTransaction().commit(); //закрытие транзакции - коммит
            System.out.println("Done!");

        } finally {
            factory.close();
            session.close();
        }
    }
}
