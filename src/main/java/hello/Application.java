package hello;

import domain.Department;
import domain.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.HibernateUtil;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        /*Department department = new Department("java");
        session.save(department);

        session.save(new Employee("Jakab Gipsz",department));
        session.save(new Employee("Captain Nemo",department));

        session.getTransaction().commit();*/

        Query q = session.createQuery("From Employee ");

        List<Employee> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
    }
}