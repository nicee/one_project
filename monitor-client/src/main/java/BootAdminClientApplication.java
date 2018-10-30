import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author rookie
 * @project one_project
 * @time 2018/10/23.11:50
 */
@SpringBootConfiguration
@EnableAutoConfiguration
public class BootAdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAdminClientApplication.class, args);
    }

}
