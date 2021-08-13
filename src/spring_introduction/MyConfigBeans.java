package spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("myApp.properties")
public class MyConfigBeans {

    @Bean
//    @Scope("prototype")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    public PersonConfigBean personConfigBean() {
        return new PersonConfigBean(catBean());
    }
}
