package cn.tx.test;

import cn.tx.demo6.Customer;
import cn.tx.demo6.SpringConfig6;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * Spring整合Junit 注解的方式测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 加载配置类
@ContextConfiguration(classes = SpringConfig6.class)
public class Demo6 {

    // 按类型注入
    @Autowired
    private Customer customer;

    /**
     * 测试
     */
    @Test
    public void run1(){
        customer.save();
    }

}
