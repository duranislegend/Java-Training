/**
 * 
 */
package DataSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import java.io.*;

import javax.sql.DataSource;

/**
 * @author congyang
 *
 */
public class SimpleConncetionPoolDataSource implements DataSource {

	private Properties pros;
	private String url;
	private String name;
	private String pwd;
	private int max;
	private List<Connection> conns;

	public SimpleConncetionPoolDataSource() throws FileNotFoundException,
			IOException {
		this("jdbc.properties");
	}

	public SimpleConncetionPoolDataSource(String fileName)
			throws FileNotFoundException, IOException {
		pros = new Properties();
		pros.load(new  FileInputStream(fileName));
		url = pros.getProperty("dburl");
		name = pros.getProperty("dbuser");
		pwd = pros.getProperty("dbpassword");
		max = Integer.parseInt(pros.getProperty("max"));
		conns = Collections.synchronizedList(new ArrayList<Connection>());
	}
	
	public synchronized Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		if (conns.isEmpty()) {
			Connection con = DriverManager.getConnection(url, name,pwd);
			System.out.println(con.createStatement().execute("select top 1 from t_message"));
			return new ConnectionWrapper(con, conns, max);
			//return DriverManager.getConnection("jdbc:oracle:thin:@legend:1521:ORCL", "gzcs", "gzcs");
		} else {
			return conns.remove(conns.size() - 1);
		}

	}
	private class ConnectionWrapper implements Connection{
		private Connection conn;

		private List<Connection> conns;
		private int max;

		public ConnectionWrapper(Connection conn, List<Connection> conns,
				int max) {
			this.conn = conn;
			this.conns = conns;
			this.max = max;
		}
		/* (non-Javadoc)
		 * @see java.sql.Connection#close()
		 */
		@Override
		public void close() throws SQLException {
			// TODO Auto-generated method stub
			if(max == conns.size()){
				conn.close();
			}else{
				conns.add(this);
			}
		}

		/* (non-Javadoc)
		 * @see java.sql.Wrapper#unwrap(java.lang.Class)
		 */
		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
		 */
		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createStatement()
		 */
		@Override
		public Statement createStatement() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareStatement(java.lang.String)
		 */
		@Override
		public PreparedStatement prepareStatement(String sql)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareCall(java.lang.String)
		 */
		@Override
		public CallableStatement prepareCall(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#nativeSQL(java.lang.String)
		 */
		@Override
		public String nativeSQL(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setAutoCommit(boolean)
		 */
		@Override
		public void setAutoCommit(boolean autoCommit) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getAutoCommit()
		 */
		@Override
		public boolean getAutoCommit() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#commit()
		 */
		@Override
		public void commit() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#rollback()
		 */
		@Override
		public void rollback() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		

		/* (non-Javadoc)
		 * @see java.sql.Connection#isClosed()
		 */
		@Override
		public boolean isClosed() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getMetaData()
		 */
		@Override
		public DatabaseMetaData getMetaData() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setReadOnly(boolean)
		 */
		@Override
		public void setReadOnly(boolean readOnly) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#isReadOnly()
		 */
		@Override
		public boolean isReadOnly() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setCatalog(java.lang.String)
		 */
		@Override
		public void setCatalog(String catalog) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getCatalog()
		 */
		@Override
		public String getCatalog() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setTransactionIsolation(int)
		 */
		@Override
		public void setTransactionIsolation(int level) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getTransactionIsolation()
		 */
		@Override
		public int getTransactionIsolation() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getWarnings()
		 */
		@Override
		public SQLWarning getWarnings() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#clearWarnings()
		 */
		@Override
		public void clearWarnings() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createStatement(int, int)
		 */
		@Override
		public Statement createStatement(int resultSetType,
				int resultSetConcurrency) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
		 */
		@Override
		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
		 */
		@Override
		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getTypeMap()
		 */
		@Override
		public Map<String, Class<?>> getTypeMap() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setTypeMap(java.util.Map)
		 */
		@Override
		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setHoldability(int)
		 */
		@Override
		public void setHoldability(int holdability) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getHoldability()
		 */
		@Override
		public int getHoldability() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setSavepoint()
		 */
		@Override
		public Savepoint setSavepoint() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setSavepoint(java.lang.String)
		 */
		@Override
		public Savepoint setSavepoint(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#rollback(java.sql.Savepoint)
		 */
		@Override
		public void rollback(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
		 */
		@Override
		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createStatement(int, int, int)
		 */
		@Override
		public Statement createStatement(int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
		 */
		@Override
		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
		 */
		@Override
		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareStatement(java.lang.String, int)
		 */
		@Override
		public PreparedStatement prepareStatement(String sql,
				int autoGeneratedKeys) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
		 */
		@Override
		public PreparedStatement prepareStatement(String sql,
				int[] columnIndexes) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
		 */
		@Override
		public PreparedStatement prepareStatement(String sql,
				String[] columnNames) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createClob()
		 */
		@Override
		public Clob createClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createBlob()
		 */
		@Override
		public Blob createBlob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createNClob()
		 */
		@Override
		public NClob createNClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createSQLXML()
		 */
		@Override
		public SQLXML createSQLXML() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#isValid(int)
		 */
		@Override
		public boolean isValid(int timeout) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setClientInfo(java.lang.String, java.lang.String)
		 */
		@Override
		public void setClientInfo(String name, String value)
				throws SQLClientInfoException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setClientInfo(java.util.Properties)
		 */
		@Override
		public void setClientInfo(Properties properties)
				throws SQLClientInfoException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getClientInfo(java.lang.String)
		 */
		@Override
		public String getClientInfo(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getClientInfo()
		 */
		@Override
		public Properties getClientInfo() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createArrayOf(java.lang.String, java.lang.Object[])
		 */
		@Override
		public Array createArrayOf(String typeName, Object[] elements)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
		 */
		
		/* (non-Javadoc)
		 * @see java.sql.Connection#setSchema(java.lang.String)
		 */
		@Override
		public void setSchema(String schema) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getSchema()
		 */
		@Override
		public String getSchema() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#abort(java.util.concurrent.Executor)
		 */
		@Override
		public void abort(Executor executor) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#setNetworkTimeout(java.util.concurrent.Executor, int)
		 */
		@Override
		public void setNetworkTimeout(Executor executor, int milliseconds)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#getNetworkTimeout()
		 */
		@Override
		public int getNetworkTimeout() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
		 */
		@Override
		public Struct createStruct(String typeName, Object[] attributes)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getLogWriter()
	 */
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
	 */
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#setLoginTimeout(int)
	 */
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getLoginTimeout()
	 */
	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getParentLogger()
	 */
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
	 */
	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
