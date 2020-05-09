package cn.tx.demo3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
@Component(value = "person")
public class Person {

    @Value("张三")
    private String pname;

    @Override
    public String toString() {
        return "Person{" +
                "pname='" + pname + '\'' +
                '}';
    }

}
