package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4ScopePrototype {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextScope.xml");

        Person person1 = context.getBean("myPersonPrototype", Person.class);
        Person person2 = context.getBean("myPersonPrototype", Person.class);

        System.out.println(person1);
        System.out.println(person2);

        System.out.println(person1 == person2);

        context.close();
    }
}
