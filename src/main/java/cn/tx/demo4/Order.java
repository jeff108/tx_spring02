package cn.tx.demo4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
@Component
public class Order {

    @Value("北京")
    private String address;

    @Override
    public String toString() {
        return "Order{" +
                "address='" + address + '\'' +
                '}';
    }

}
