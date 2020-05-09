package cn.tx.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
// 默认当前类名就是ID名称，首字母小写
@Component(value = "c")
// @Controller
// @Service(value = "c")
// @Repository(value = "c")
// @Scope(value = "singleton")     // 默认值，单例的
// @Scope(value = "prototype")         // 多例的
public class Car {

    // 注解注入值，属性set方法是可以省略不写的。
    // 只有一个属性，属性的名称是value，value是可以省略不写的
    @Value("大奔2")
    private String cname;

    @Value(value = "400000")
    private Double money;

    // 也不用提供set方法
    // 按类型自动装配的注解，和id名称没有关系
    @Autowired
    // 按id的名称注入，Qualifier不能单独使用，需要Autowired一起使用。
    // @Qualifier(value = "person")
    // @Resource Java提供的注解，按名称注入对象，属性名称是name
    // @Resource(name = "person")
    private Person person;

    /**
     * Car对象创建完成后，调用init方法进行初始化操作
     */
    @PostConstruct
    public void init(){
        System.out.println("操作...");
    }

    /*
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
    */

    @Override
    public String toString() {
        return "Car{" +
                "cname='" + cname + '\'' +
                ", money=" + money +
                ", person=" + person +
                '}';
    }
}
