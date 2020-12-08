package com.structural.facade;

import java.util.HashMap;
import java.util.Map;

/**
 * Structural Design pattern improves the structure of java code Can be used
 * when we have multiple interfaces of similar kind of jobs, then we add a
 * facade interface which help us provide a better interface to these interfaces
 * and clients. It basically help in routing to related interface
 */
public class FacadePatternExample {

	public static void main(String[] args) throws Exception {

		/**
		 * The client doesn't need to know anything about the subsystem implementation
		 * except initializing driver class for required database.
		 * 
		 * Client just interacts with framework interface rather than database specific
		 * classes.
		 * 
		 * Here DriverManager acts as a facade for the underlying subsystem.
		 * 
		 * We can impose security checks or any other access verifications in facade
		 * before accessing the actual subsystem.
		 */
		Class.forName("com.bethecoder.tutorials.dp.facade2.oracle.OracleJDBCDriver");
		IConnection connection = DriverManager.getConnection("oracle");
		IStatement statement = connection.createStatement();
		statement.executeQuery("select * from Employee");

		Class.forName("com.bethecoder.tutorials.dp.facade2.mysql.MySQLJDBCDriver");
		connection = DriverManager.getConnection("mysql");
		statement = connection.createStatement();
		statement.executeQuery("select * from Employee");
	}
}

class OracleJDBCDriver implements IJDBCDriver {

	@Override
	public IConnection getConnection() {
		return new OracleConnection();
	}

	@Override
	public String getDBVendor() {
		return "oracle";
	}

	/**
	 * Register this driver with Driver Manager.
	 */
	static {
		DriverManager.registerDriver(new OracleJDBCDriver());
	}
}

class DriverManager {

	private static Map<String, IJDBCDriver> driverMap = new HashMap<String, IJDBCDriver>();

	private DriverManager() {
	}

	public static void registerDriver(IJDBCDriver driver) {
		driverMap.put(driver.getDBVendor(), driver);
	}

	public static IConnection getConnection(String database) {
		if (driverMap.containsKey(database)) {
			return driverMap.get(database).getConnection();
		}
		throw new IllegalArgumentException("No driver fournd for database : " + database);
	}
}

class OracleConnection implements IConnection {
	@Override
	public IStatement createStatement() {
		return new OracleStatement();
	}

}

class OracleStatement implements IStatement {
	@Override
	public void executeQuery(String query) {
		System.out.println("Oracle JDBC driver executing query : " + query);
	}

}

interface IJDBCDriver {
	public String getDBVendor();

	public IConnection getConnection();
}

interface IConnection {
	public IStatement createStatement();
}

interface IStatement {
	public void executeQuery(String query);
}
