package km.likelion.gitcollabo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class GitCollaboApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        System.setProperty("user.timezone", "Asia/Seoul");
        SpringApplication.run(GitCollaboApplication.class, args);
    }

}
