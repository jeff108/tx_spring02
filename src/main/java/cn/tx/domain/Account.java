package cn.tx.domain;

import java.io.Serializable;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * 账户
 */
public class Account implements Serializable{

    // 主键
    private Integer id;
    // 名称
    private String name;
    // 金额
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
