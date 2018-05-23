package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static ConnectionUtil connectionUtiliy = null;

	private Connection connection = null;

	private ConnectionUtil() {
	}

	public static ConnectionUtil getInstance() throws IOException, IllegalAccessException, SQLException, ClassNotFoundException{

		synchronized(ConnectionUtil.class){

			if(connectionUtiliy == null){
				Properties properties = new Properties();
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties"));
				connectionUtiliy = new ConnectionUtil();
				Class.forName("com.mysql.jdbc.Driver");
				connectionUtiliy.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", properties));
			}
			return connectionUtiliy;
		}
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		if(connection.isClosed()){

			Properties properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties"));
			Class.forName("com.mysql.jdbc.Driver");
			connectionUtiliy.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", properties));
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}