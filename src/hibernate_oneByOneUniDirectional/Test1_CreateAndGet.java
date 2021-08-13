package hibernate_oneByOneUniDirectional;

import hibernate_oneByOneUniDirectional.entity.Detail;
import hibernate_oneByOneUniDirectional.entity.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_CreateAndGet {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Worker.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession(); // получить сессию
            session.beginTransaction(); // открытие транзакции

//            Worker worker = new Worker("Vasya", "Levin", "Sales", 450);
//            Detail detail = new Detail("Samara", "234", "vasyan@ya.ru");
//
//            worker.setWorkDetail(detail);
//

//
//            session.save(worker); //сохранение записей в БД

            Worker worker = session.get(Worker.class, 2);
//            session.delete(worker); // удаление работника и деталей, тк oneToOne cascade = CascadeType.ALL
            System.out.println(worker.getWorkDetail());


            session.getTransaction().commit(); //закрытие транзакции - коммит
            System.out.println("Done!");

        } finally {
            factory.close();
            session.close();
        }
    }
}
