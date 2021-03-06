package cn.tx.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 事务的工具类
 * @author rt
 */
public class TxUtils {
	
	private static DruidDataSource ds = null;

	// 使用ThreadLocal存储当前线程中的Connection对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	// 在静态代码块中创建数据库连接池
	static {
		try {
			// 通过代码创建C3P0数据库连接池
			ds = new DruidDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql:///spring_db");
			ds.setUsername("root");
			ds.setPassword("root");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * @Method: getConnection
	 * @Description: 从数据源中获取数据库连接
	 * @Anthor:
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		// 从当前线程中获取Connection
		Connection conn = threadLocal.get();

		if (conn == null) {
			// 从数据源中获取数据库连接
			conn = getDataSource().getConnection();
			// 将conn绑定到当前线程
			threadLocal.set(conn);
		}
		return conn;
	}

	/**
	 * @Method: startTransaction
	 * @Description: 开启事务
	 * @Anthor:
	 *
	 */
	public static void startTransaction() {
		try {
			Connection conn = threadLocal.get();
			if (conn == null) {
				conn = getConnection();
				// 把 conn绑定到当前线程上
				threadLocal.set(conn);
			}

			// 开启事务
			conn.setAutoCommit(false);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Method: rollback
	 * @Description:回滚事务
	 * @Anthor:
	 */
	public static void rollback() {
		try {
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (conn != null) {
				// 回滚事务
				conn.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Method: commit
	 * @Description:提交事务
	 * @Anthor:
	 */
	public static void commit() {
		try {
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (conn != null) {

				// 提交事务
				conn.commit();

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Method: close
	 * @Description:关闭数据库连接(注意，并不是真的关闭，而是把连接还给数据库连接池)
	 * @Anthor:
	 *
	 */
	public static void close() {
		try {
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (conn != null) {
				conn.close();
				// 解除当前线程上绑定conn
				threadLocal.remove();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @Anthor:
	 * @return DataSource
	 */
	public static DataSource getDataSource() {
		// 从数据源中获取数据库连接
		return ds;
	}

}
