import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author rookie
 * @project one_project
 * @time 2018/10/23.11:50
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@EnableDiscoveryClient
public class BootAdminClientBakApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAdminClientBakApplication.class, args);
    }

}
