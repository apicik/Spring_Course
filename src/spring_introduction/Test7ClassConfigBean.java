package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7ClassConfigBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigBeans.class);

        PersonConfigBean person = context.getBean("personConfigBean", PersonConfigBean.class);

        person.callYourPet();

        System.out.println(person.getAge());
        System.out.println(person.getSurName());

        context.close();
    }
}
