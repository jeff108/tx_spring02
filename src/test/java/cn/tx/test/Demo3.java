package cn.tx.test;

import cn.tx.demo2.UserService;
import cn.tx.demo3.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class Demo3 {

    @Test
    public void run1(){
        // 工厂
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_anno.xml");
        // 获取对象
        Car car = (Car) ac.getBean("c");
        System.out.println(car);
    }

}
