package com.fu.gradledemo.hikari;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class HikariConfig {
    /**
     * 配置别名
     */
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    /**
     * 配置mapper的扫描，找到所有的mapper.xml映射文件
     */
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.mysql1")
    public HikariDataSource mysql1DataSource() {
        return new HikariDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.mysql2")
    public HikariDataSource mysql2DataSource() {
        return new HikariDataSource();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put("mysql1", mysql1DataSource());
        targetDataSources.put("mysql2", mysql2DataSource());
        return new DynamicDataSource(mysql1DataSource(), targetDataSources);
    }

    /**
     * SqlSessionFactory 配置并放入容器中
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return sqlSessionFactoryBean.getObject();
    }
}
