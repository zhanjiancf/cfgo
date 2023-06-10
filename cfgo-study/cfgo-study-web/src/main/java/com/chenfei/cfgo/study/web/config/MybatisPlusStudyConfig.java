package com.chenfei.cfgo.study.web.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.chenfei.cfgo.study.web.constant.TransactionManagerType;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2022/10/22 16:21
 */
@Configuration
@MapperScan(basePackages = "com.chenfei.cfgo.study.web.mapper.study", sqlSessionTemplateRef = "mysqlStudySqlSessionTemplate")
public class MybatisPlusStudyConfig {

    @Value("${spring.profiles.active}")
    private String active;

    private MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean(name = "mysqlStudySqlSessionFactory")
    SqlSessionFactory sqlSessionFactory(@Qualifier(value = "mysqlStudyDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        MybatisConfiguration configuration = new MybatisConfiguration();
        if ("dev".equalsIgnoreCase(active)) {
            configuration.setLogImpl(StdOutImpl.class);
        }
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/study/**/*.xml"));
        sqlSessionFactory.setPlugins(this.mybatisPlusInterceptor());
        return sqlSessionFactory.getObject();
    }

    @Bean(name = "mysqlStudySqlSessionTemplate")
    SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = "mysqlStudySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = TransactionManagerType.STUDY)
    DataSourceTransactionManager transactionManager(@Qualifier(value = "mysqlStudyDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
