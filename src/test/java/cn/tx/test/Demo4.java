package cn.tx.test;

import cn.tx.demo4.Order;
import cn.tx.demo4.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class Demo4 {

    /**
     * 编写程序，需要加载配置类
     */
    @Test
    public void run1(){
        // 创建工厂，加载配置类
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 获取到对象
        Order order = (Order) ac.getBean("order");
        System.out.println(order);
    }

    /**
     * 编写程序，需要加载配置类
     */
    @Test
    public void run2(){
        // 创建工厂，加载配置类
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 获取到对象
        DataSource dataSource = (DataSource) ac.getBean("dataSource");
        System.out.println(dataSource);
    }

}
