package dataCore;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
//@Import(DataSource.class)
@EnableTransactionManagement//开启扫描@Transcational
public class MyBatisConfig {
    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);
    private static final String DBPROPERTIES = "config/dataDB.properties";
    private static final String CONFIGLOCATION = "config/mybatis-config.xml";
    private static final String MAPPERLOCATIONS = "classpath:mapper/*.xml";

    public Properties getProperties() {
        Properties properties = new Properties();
        //spring-core提供的一个加载properties的类
        Resource resource = new ClassPathResource(DBPROPERTIES);
        //InputStream resourceAsStream = MyBatisConfig.class.getClassLoader().getResourceAsStream(dbProperties);
        try {
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            logger.error("读取配置文件异常", e);
            e.printStackTrace();
        }
        return properties;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DataSource dataSource = null;
        Properties properties = getProperties();
        try {
            //使用默认的配置--包括其字段的命名。如果想自定义请new DruidData();来自定义
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactory(
            @Qualifier(value = "dataSource") DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //设置mybatis主文件夹
        Resource configLocation = new ClassPathResource(CONFIGLOCATION);
        factoryBean.setConfigLocation(configLocation);
        //加载数据资源
        factoryBean.setDataSource(dataSource);
        //解析classpath:*/*.xml等的路径
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            //获取对应的加载的mybatis文件的资源
            Resource[] mapperLocations = patternResolver.getResources(MAPPERLOCATIONS);
            factoryBean.setMapperLocations(mapperLocations);//加入mybatis中的映射文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //指定扫描的包名称
        mapperScannerConfigurer.setBasePackage("dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        DataSourceTransactionManager txmanager = new DataSourceTransactionManager();
        txmanager.setDataSource(dataSource);
        return txmanager;
    }
}
