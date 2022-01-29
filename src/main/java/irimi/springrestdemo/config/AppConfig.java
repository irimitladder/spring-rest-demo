package irimi.springrestdemo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("irimi.springrestdemo")
@PropertySource("classpath:db-connection.properties")
public class AppConfig
        implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager getDbTransactionManager(SessionFactory dbSessionFactory) {
        HibernateTransactionManager dbTransactionManager = new HibernateTransactionManager();
        dbTransactionManager.setSessionFactory(dbSessionFactory);
        return dbTransactionManager;
    }

    @Bean
    public LocalSessionFactoryBean getDbSessionFactory() {
        LocalSessionFactoryBean dbSessionFactory = new LocalSessionFactoryBean();
        dbSessionFactory.setDataSource(getDb());
        dbSessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
        dbSessionFactory.setHibernateProperties(getHibernateProperties());
        return dbSessionFactory;
    }

    @Bean
    public DataSource getDb() {
        ComboPooledDataSource db = new ComboPooledDataSource();
        try {
            db.setDriverClass(environment.getProperty("jdbc.driver"));
            db.setJdbcUrl(environment.getProperty("jdbc.url"));
            db.setUser(environment.getProperty("jdbc.userName"));
            db.setPassword(environment.getProperty("jdbc.userPassword"));
            db.setInitialPoolSize(getIntegerPropertyValue("c3p0.poolSizeInitial"));
            db.setMinPoolSize(getIntegerPropertyValue("c3p0.poolSizeMin"));
            db.setMaxPoolSize(getIntegerPropertyValue("c3p0.poolSizeMax"));
            db.setMaxIdleTime(getIntegerPropertyValue("c3p0.timeIdleMax"));
        } catch (PropertyVetoException exception) {
            throw new RuntimeException(exception);
        }
        return db;
    }

    private Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.showSql"));
        return hibernateProperties;
    }

    private int getIntegerPropertyValue(String propertyName) {
        String propertyValue = environment.getProperty(propertyName);
        int integerPropertyValue = Integer.parseInt(propertyValue);
        return integerPropertyValue;
    }
}
