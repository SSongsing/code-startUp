package codestartup.codestartup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CodeStartUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeStartUpApplication.class, args);
    }

}
