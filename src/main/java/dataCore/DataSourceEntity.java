package dataCore;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component//加载这个主键
@ConfigurationProperties(prefix = "mysql")//导入对应的properties中的键值对
@PropertySource({"classpath:/config/dataDB.properties"})//提供是在那里的配置文件，不可以用*来代替
public class DataSourceEntity {
    private String username;
    private String dbUrl;
    private String password;
    private String driver;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
