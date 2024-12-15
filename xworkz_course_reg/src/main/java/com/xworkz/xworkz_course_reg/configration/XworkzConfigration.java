package com.xworkz.xworkz_course_reg.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.xworkz.xworkz_course_reg")
@EnableWebMvc
public class XworkzConfigration {
    XworkzConfigration(){
        System.out.println("This is a XworkzConfigration const....");
    }

    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/", ".jsp");
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/xworkz_course");
        dataSource.setUsername("root");
        dataSource.setPassword("Nagaraj@007");
        return dataSource;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContEnititymangFactBean() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();

        // Specify the package to scan for entities
        bean.setPackagesToScan("com.xworkz.xworkz_course_reg.entity");

        // Set the data source (ensure your dataSource() method is correct)
        bean.setDataSource(dataSource());

        // Specify the JPA vendor adapter (using Hibernate in this case)
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return bean;
    }

}
