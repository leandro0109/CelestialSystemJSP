package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:sqlserver://192.168.1.72:1433;databaseName=DBAstronomica;user=sa;password=1234;encrypt=true;trustServerCertificate=true";
	
		// Estabelecer conexão com base de dados
		public static Connection getConnection() throws SQLException, ClassNotFoundException{
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				return DriverManager.getConnection(URL);		
			} finally {
				System.out.println("Conectado com sucesso!");
			}
		}
}
