package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class Dog implements Pet {
    @Override
    public void say() {
        System.out.println("Bow!");
    }
}
