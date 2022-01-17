package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection(){
		if (conn == null) {
			try {
				// Acessa o loadProperties do método loadProperties;
				Properties props = loadProperties();
				//Acessa o arquivo db.properties e pega os dados presente na variável "dburl".
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	private static Properties loadProperties(){
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeConnection() {
		// Testando se a conexão está instanciada.
		// Se estiver instanciada ela manda fechar.
		if(conn != null) {
			try {
			conn.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
