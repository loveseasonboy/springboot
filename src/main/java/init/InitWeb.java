package init;

import dataCore.MyBatisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.WebApplicationContext;

/**
 *@EnableAutoConfiguration 和 @SpringBootApplication,@ComponentScan 是等价的
 * 但是有的时候会出现扫描不到配置的注入。因此最好是自己配置一下
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"controller"})
@Import(MyBatisConfig.class)
public class InitWeb {


    public static void main(String[] args) {
        SpringApplication.run(InitWeb.class,args);
    }
}
