package cn.tx.service;

import cn.tx.dao.AccountDao;
import cn.tx.dao.AccountDaoImpl;
import cn.tx.domain.Account;

import java.util.List;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class AccountServiceImpl implements AccountService {

    // 成员属性
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        // 创建dao对象
         AccountDao accountDao = new AccountDaoImpl();

        // 调用对象的方法
        return accountDao.findAll();
    }

}
