package init;

import dataCore.MyBatisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PutMapping;

@SpringBootApplication
//@Import(MyBatisConfig.class)
@ComponentScan(basePackages={"service","dataCore"})
//@MapperScan(basePackages = {"dao"})
public class ServerInit {
    public static void main(String[] args) {
        SpringApplication.run(ServerInit.class,args);
    }
}
