package car_rental.REST.config;


import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class DbConfig {
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
//        dataSourceBuilder.url("jdbc:sqlite:test.db");
//        return dataSourceBuilder.build();
//    }
}
