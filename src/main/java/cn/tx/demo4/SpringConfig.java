package cn.tx.demo4;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * Spring的配置类，替换掉applicationContext.xml
 *
 */
// 声明当前类是配置类
@Configuration
// 扫描指定的包结构
@ComponentScan(value = "cn.tx.demo4")
// @ComponentScan(value = {"cn.tx.demo4","cn.tx.demo3"})
// 引入新的配置类
@Import(value = {SpringConfig2.class})
public class SpringConfig {

    /**
     * 创建连接池对象，返回对象，把该方法创建后的对象存入到连接池中，使用@Bean注解解决

         <!--配置连接池对象-->
         <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
             <property name="driverClassName" value="com.mysql.jdbc.Driver" />
             <property name="url" value="jdbc:mysql:///spring_db" />
             <property name="username" value="root" />
             <property name="password" value="root" />
         </bean>
     *
     * @return
     */
    @Bean(name="dataSource")
    public DataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

}
















