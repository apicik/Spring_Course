package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5ConfigAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextComponentScan.xml");

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        System.out.println(person.getSurName());
        System.out.println(person.getAge());

        System.out.println("------------------------");

        Dog dog = context.getBean("dog", Dog.class);
        dog.say();

        Cat catBean = context.getBean("catBean", Cat.class);
        catBean.say();

        context.close();
    }
}
