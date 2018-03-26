package com.cdc.mitrais.database.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.mitrais.dao.ArticleDAO;
import com.cdc.mitrais.dao.Test;


public class ConnectionPool {

	/*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/zeus";

	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "";*/
	
	private String db_driver;
	private String db_url;
	private String db_user;
	private String db_password;

	private static GenericObjectPool gPool = null;

	private ResultSet resultset = null;
	private Connection connection = null;
	private PreparedStatement statement = null;
	private DataSource dataSource;
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

	public ConnectionPool() throws Exception {
		loadDBProperties();
		dataSource = setUpPool();
		connection = getDataSource().getConnection();
	}

	public void loadDBProperties() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "db.properties";
			input = ConnectionPool.class.getClassLoader().getResourceAsStream(filename);
			if(input==null){
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

			//load a properties file from class path, inside static method
			prop.load(input);

			this.setDb_driver(prop.getProperty("db_driver"));
			this.setDb_url(prop.getProperty("db_url"));
			this.setDb_user(prop.getProperty("db_user"));
			this.setDb_password(prop.getProperty("db_password"));
			//get the property value and print it out
			logger.debug(prop.getProperty("db_driver"));
			logger.debug(prop.getProperty("db_user"));
			logger.debug(prop.getProperty("db_password"));
			logger.debug(prop.getProperty("db_url"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
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

		Class.forName(this.getDb_driver());
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);
		//ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(JDBC_URL, JDBC_USER, JDBC_PASS);
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(this.getDb_url(), this.getDb_user(), this.getDb_password());
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

	public String getDb_driver() {
		return db_driver;
	}

	public void setDb_driver(String db_driver) {
		this.db_driver = db_driver;
	}

	public String getDb_url() {
		return db_url;
	}

	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}

	public String getDb_user() {
		return db_user;
	}

	public void setDb_user(String db_user) {
		this.db_user = db_user;
	}

	public String getDb_password() {
		return db_password;
	}

	public void setDb_password(String db_password) {
		this.db_password = db_password;
	}

}
