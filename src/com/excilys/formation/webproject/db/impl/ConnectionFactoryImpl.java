package com.excilys.formation.webproject.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public enum ConnectionFactoryImpl {
	
	Singleton;
 
private BoneCP connectionPool = null;
 
private void configureConnPool() {
 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalArgumentException("Could not find the driver for jdbc");
	}
	BoneCPConfig config = new BoneCPConfig();
	config.setJdbcUrl("jdbc:mysql://localhost:3306/computer-database-db");
	config.setUsername("root");
	config.setPassword("root");
	config.setMinConnectionsPerPartition(5);   
	config.setMaxConnectionsPerPartition(10);
	config.setPartitionCount(2); //2*5 = 10 connection will be available
	config.setLazyInit(true);
	try {
		connectionPool = new BoneCP(config); // setup the connection pool
	} catch (SQLException e) {
		throw new RuntimeException("Could not configure the connection pool");
	}
	System.out.println("contextInitialized.....Connection Pooling is configured");
	System.out.println("Total connections ==> " + connectionPool.getTotalCreatedConnections());
	setConnectionPool(connectionPool);
}
 
public void shutdownConnPool() {
 
	try {
		BoneCP connectionPool = getConnectionPool();
		System.out.println("contextDestroyed....");
		if (connectionPool != null) {
			connectionPool.shutdown(); //this method must be called only once when the application stops.
			//you don't need to call it every time when you get a connection from the Connection Pool
			System.out.println("contextDestroyed.....Connection Pooling shut down!");
		}
 
	} catch (Exception e) {
		e.printStackTrace();
	}
}
 
public Connection getConnection() {
 
Connection conn = null;

	//first connection ?
	if (connectionPool ==null) configureConnPool();


	try {
	conn = getConnectionPool().getConnection();
 	//will get a thread-safe connection from the BoneCP connection pool.
 	//synchronization of the method will be done inside BoneCP source
 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
}
 
public void closeStatement(Statement stmt) {
	try {
		if (stmt != null)
			stmt.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
 
public void closeResultSet(ResultSet rs) {
	try {
		if (rs != null)
			rs.close();
	} catch (Exception e) {
		e.printStackTrace();
	} 
}
 
public void closeConnection(Connection conn) {
	try {
		if (conn != null)
			conn.close(); //release the connection - the name is tricky but connection is not closed it is released
		//and it will stay in pool
	} catch (SQLException e) {
		e.printStackTrace();
	} 
}

public void disconnect(Statement stmt,ResultSet rs,Connection conn) {
	closeStatement(stmt);
	closeResultSet(rs);
	closeConnection(conn);
}
 
public BoneCP getConnectionPool() {
	return connectionPool;
}
 
public void setConnectionPool(BoneCP connectionPool) {
	this.connectionPool = connectionPool;
}
 
}