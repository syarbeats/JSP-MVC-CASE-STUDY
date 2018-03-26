package com.cdc.mitrais.database.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;


public class ConnectionPool {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/zeus";
	
	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "";
	
	private static GenericObjectPool gPool = null;
	
	private ResultSet resultset = null;
	private Connection connection = null;
	private PreparedStatement statement = null;
	private DataSource dataSource;
	
	public ConnectionPool() throws Exception {
		dataSource = setUpPool();
		connection = getDataSource().getConnection();
	}
	
	public DataSource getDataSource() {
		
		return dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		return connection;
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}
	
	public DataSource setUpPool() throws Exception{
		
		Class.forName(JDBC_DRIVER);
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(JDBC_URL, JDBC_USER, JDBC_PASS);
		PoolableConnectionFactory poolableConnection = new PoolableConnectionFactory(connectionFactory, gPool, null, null, false, true);
		
		return new PoolingDataSource(gPool);
	}
	
	public GenericObjectPool getConnectionPool() {
		return gPool;
	}
	
	public void printDbStatus() {
		System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
	}
	
	public void releaseResource() {
		if(resultset != null) {
			try {
				resultset.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
