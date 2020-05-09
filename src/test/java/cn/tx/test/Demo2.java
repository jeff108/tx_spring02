package cn.tx.test;

import cn.tx.demo2.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class Demo2 {

    /**
     * IOC注解方式的入门
     */
    @Test
    public void run1(){
        // 工厂
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_anno.xml");
        // 获取对象
        UserService userService = (UserService) ac.getBean("us");
        userService.hello();
    }

}
