package init;

import dataCore.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MyBatisConfig.class)
@ComponentScan(basePackages={"service"})
public class ServerInit {
    public static void main(String[] args) {
        SpringApplication.run(ServerInit.class,args);
    }
}
