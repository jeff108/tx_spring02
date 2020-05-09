package cn.tx.dao;

import cn.tx.domain.Account;
import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class AccountDaoImpl implements AccountDao {

    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

   // @Override
    public List<Account> findAll() {

        /*
        // 使用JDBC的程序
        // 创建连接池对象，设置4个参数
        DruidDataSource dataSource = new DruidDataSource();
        // 设置4个参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        */

        // 定义对象
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Account> list = new ArrayList<>();

        try {
            // 获取连接
            conn = dataSource.getConnection();
            // 编写sql
            String sql = "select * from account";
            // 预编译
            stmt = conn.prepareStatement(sql);
            // 执行sql
            rs = stmt.executeQuery();
            // 遍历结果集
            while (rs.next()){
                // 进行数据封装
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setMoney(rs.getDouble("money"));
                // 存储
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
