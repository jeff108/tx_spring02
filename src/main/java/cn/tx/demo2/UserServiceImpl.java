package cn.tx.demo2;

import org.springframework.stereotype.Component;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * <bean id="us" class="cn.tx.demo2.UserServiceImpl" />
 */
// 组件，作用：把当前类使用IOC容器进行管理，如果没有指定名称，默认使用类名，首字母是小写。userServiceImpl。或者自己指定名称
@Component(value = "us")
public class UserServiceImpl implements UserService {

    public void hello() {
        System.out.println("Hello IOC注解...");
    }

}
