package cn.tx.test;

import cn.tx.demo5.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * Spring整合Junit单元测试
 *
 */
@RunWith(value = SpringJUnit4ClassRunner.class)     // 运行单元测试
@ContextConfiguration(value = "classpath:applicationContext_test.xml")      // 加载类路径下的配置文件
public class Demo5 {

    // 测试哪一个对象，把该对象注入进来，在测试环境下，可以使用注解的方式注入测试的对象
    // 按类型自动注入
    @Autowired
    private User user;

    @Test
    public void run1(){
        // 创建工厂，加载配置文件......
        // 调用对象的方法
        user.sayHello();
    }

    @Test
    public void run2(){
        // 调用对象的方法
        user.sayHello();
    }

}
