package com.qingshu.school.home;

import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp.AbandonedConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.SQLNestedException;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.apache.commons.pool.impl.GenericKeyedObjectPoolFactory;

public class DynicDataSource extends BasicDataSource {
	private AbandonedConfig abandonedConfig;
	private boolean reset;
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	
	public void setReset(boolean reset) {
		this.reset = reset;
	}
	protected synchronized DataSource createDataSource() throws SQLException {

		if (reset) {
			dataSource = null;
		} else {
			if (closed) {
				throw new SQLException("Data source is closed");
			}
		}
		
		// Return the pool if we have already created it
		if (dataSource != null) {
			return (dataSource);
		}
		
		// create factory which returns raw physical connections
		ConnectionFactory driverConnectionFactory = createConnectionFactory();
		
		// create a pool for our connections
		createConnectionPool();
		
		// Set up statement pool, if desired
		GenericKeyedObjectPoolFactory statementPoolFactory = null;
		if (isPoolPreparedStatements()) {
			statementPoolFactory = new GenericKeyedObjectPoolFactory(null, -1, // unlimited
																			   // maxActive
																			   // (per
																			   // key)
					GenericKeyedObjectPool.WHEN_EXHAUSTED_FAIL, 0, // maxWait
					1, // maxIdle (per key)
					maxOpenPreparedStatements);
		}
		
		// Set up the poolable connection factory
		createPoolableConnectionFactory(driverConnectionFactory, statementPoolFactory, abandonedConfig);
		
		// Create and return the pooling data source to manage the connections
		createDataSourceInstance();
		
		try {
			for (int i = 0; i < initialSize; i++) {
				connectionPool.addObject();
			}
		} catch (Exception e) {
			throw new SQLNestedException("Error preloading the connection pool", e);
		}
		
		return dataSource;
	}
}
