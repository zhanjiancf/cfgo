package com.chenfei.cfgo.study.web.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;

import javax.sql.DataSource;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2022/10/22 17:42
 */
@Data
public class HikariProperties {

    public void dataSource(HikariDataSource hikariDataSource) {

    }
}
