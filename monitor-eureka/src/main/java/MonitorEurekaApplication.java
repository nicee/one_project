import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author rookie
 * @project one_project
 * @time 2018/10/23.16:46
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@EnableEurekaServer
public class MonitorEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorEurekaApplication.class, args);
    }

}
