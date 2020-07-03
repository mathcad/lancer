package org.spin.migrate.admin.controller;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;
import org.spin.data.extend.RepositoryContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * TITLE
 * <p>DESCRIPTION</p>
 * <p>Created by xuweinan on 2020/5/23</p>
 *
 * @author xuweinan
 * @version 1.0
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private RepositoryContext repositoryContext;

    @GetMapping(value = "test")
    public void test() {
        Integer integer = repositoryContext.doReturningWork("select 1", r -> {
            try {
                r.next();
                return r.getInt(1);
            } catch (SQLException throwables) {
                return 0;
            }
        });
        Flyway flyway = Flyway.configure()
            .dryRunOutput(System.out)
            .baselineVersion("202005210006")
            .dataSource("jdbc:mysql://192.168.40.149:3306/test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=PRC&useSSL=false",
            "root",
            "admin").locations("filesystem://E:\\migration").licenseKey("").load();

        try {
            flyway.migrate();
        } catch (FlywayException e) {
            e.printStackTrace();
        }

        MigrationInfoService info = flyway.info();
        MigrationInfo[] all = info.all();
//        KeyPair keyPair = RSA.generateKeyPair();
//        System.out.println(HexUtils.encodeHexStringU(keyPair.getPublic().getEncoded()));
//        System.out.println(HexUtils.encodeHexStringU(keyPair.getPrivate().getEncoded()));
    }
}
