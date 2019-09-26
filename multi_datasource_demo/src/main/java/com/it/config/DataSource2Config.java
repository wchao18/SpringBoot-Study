package com.it.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author wangchao
 * @description 多数据源配置类
 * @date 2019/09/20 14:38
 */
@Configuration
@MapperScan(basePackages = "com.it.dao.mapper2", sqlSessionFactoryRef = "sqlSessionFactory2")
public class DataSource2Config {

    @Bean(name = "datasource2")
    @ConfigurationProperties(value = "spring.datasource.test2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    //事务配置
    @Bean(name = "dataSourceTransactionManager2")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("datasource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置mapper-location
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper2/*.xml"));
        //实体别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.it.dao.domain");
        //添加PageHelper插件
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "mysql");
        //是否分页合理化
        properties.setProperty("reasonable", "false");
        interceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{interceptor});
        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name = "sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
