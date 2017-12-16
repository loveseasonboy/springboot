package propertity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * 读取properties的信息
 */
@Configuration
@Component
@ConfigurationProperties
@PropertySource({"classpath:/config/dataDB.properties"})
public class ReadPropertity {
//    @Bean
//    public PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
//        ClassPathResource resource = new ClassPathResource("config/dataDB.properties");
//        PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        propertyPlaceholderConfigurer.setLocation(resource);
//        return propertyPlaceholderConfigurer;
//    }
}
