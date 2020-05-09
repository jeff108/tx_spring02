package cn.tx.test;

import cn.tx.domain.Account;
import cn.tx.service.AccountService;
import cn.tx.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class Demo1 {

    /**
     * 第一种方式，new对象的方式查询数据
     */
    @Test
    public void run1(){
        // 创建对象
        AccountService accountService = new AccountServiceImpl();
        // 调用方法
        List<Account> list = accountService.findAll();
        // 遍历
        for (Account account : list) {
            System.out.println(account);
        }
    }

    /**
     * IOC编写程序的方式
     */
    @Test
    public void run2(){
        // 工厂
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        // 调用方法
        List<Account> list = accountService.findAll();
        // 遍历
        for (Account account : list) {
            System.out.println(account);
        }
    }

}
