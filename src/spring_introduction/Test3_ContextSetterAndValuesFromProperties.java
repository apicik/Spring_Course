package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3_ContextSetterAndValuesFromProperties {
    public static void main(String[] args) {
        // Пример использования Value через сеттер, используется два контекста(во втором получаем значение из проперти-файла)
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextSetter.xml", "applicationContextValuesFromProperties.xml");
        Person person = context.getBean("myPerson", Person.class);

        System.out.println(person.getSurName() + " " + person.getAge());
        person.callYourPet();

        Person person2 = context.getBean("myPersonValuesFromProperties", Person.class);

        System.out.println(person2.getSurName() + " " + person2.getAge());
        person2.callYourPet();

        context.close();
    }
}
