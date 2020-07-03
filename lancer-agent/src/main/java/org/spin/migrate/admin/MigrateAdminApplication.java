package org.spin.migrate.admin;

import org.spin.boot.datasource.annotation.EnableDataSource;
import org.spin.boot.datasource.annotation.EnableIdGenerator;
import org.spin.boot.datasource.option.DataSourceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * TITLE
 * <p>DESCRIPTION</p>
 * <p>Created by xuweinan on 2020/5/23</p>
 *
 * @author xuweinan
 * @version 1.0
 */
@EnableIdGenerator
@EnableDataSource(DataSourceType.HIKARICP)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MigrateAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MigrateAdminApplication.class, args);
    }
}
