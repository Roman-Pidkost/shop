package roman.pidkostelnyi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import roman.pidkostelnyi.demo.entity.Category;
import roman.pidkostelnyi.demo.entity.Product;
import roman.pidkostelnyi.demo.entity.User;
import roman.pidkostelnyi.demo.repository.CategoryRepository;
import roman.pidkostelnyi.demo.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
