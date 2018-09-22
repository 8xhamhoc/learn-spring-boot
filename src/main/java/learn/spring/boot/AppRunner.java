package learn.spring.boot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppRunner implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("====== Hello Application Runner");
    }

}
