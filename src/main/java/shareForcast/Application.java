package shareForcast;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import shareForcast.util.HibernateUtil;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(){
        return HibernateUtil.getSessionFactory();
    }
}